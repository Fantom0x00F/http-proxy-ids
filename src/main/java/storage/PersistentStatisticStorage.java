package storage;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import request.RequestParameters;
import statistic.Measurement;
import statistic.ResponseStatisticRow;
import storage.entities.reverse_proxy.tables.records.ResponseCodeDistributionRecord;
import storage.entities.reverse_proxy.tables.records.ResponseSizeDistributionRecord;
import storage.entities.reverse_proxy.tables.records.TagsCountDistributionRecord;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static storage.entities.reverse_proxy.Tables.*;

public class PersistentStatisticStorage implements IStatisticStorage {

    private final DSLContext dslContext;

    public PersistentStatisticStorage(Connection connection, SQLDialect dialect) {
        dslContext = DSL.using(connection, dialect);
    }

    @Override
    public void saveLearnChunk(RequestParameters requestParameters, ResponseStatisticRow data) {
        dslContext.insertInto(LEARN_STATISTIC)
                .columns(LEARN_STATISTIC.REQUEST,
                        LEARN_STATISTIC.CODE,
                        LEARN_STATISTIC.SIZE,
                        LEARN_STATISTIC.HTML_TAGS_COUNT)
                .values(zipParameters(requestParameters),
                        data.responseCode,
                        data.responseSize,
                        data.htmlTagsCount)
                .execute();
    }

    @Override
    public List<ResponseStatisticRow> getLearnChunk(RequestParameters requestParameters) {
        return Arrays.stream(dslContext.selectFrom(LEARN_STATISTIC).fetchArray())
                .map(stRecord -> new ResponseStatisticRow(stRecord.getCode(), stRecord.getSize(), stRecord.getHtmlTagsCount()))
                .collect(Collectors.toList());
    }

    @Override
    public void eraseLearnChunks(RequestParameters requestParameters) {
        dslContext.deleteFrom(LEARN_STATISTIC)
                .where(LEARN_STATISTIC.REQUEST.eq(zipParameters(requestParameters)))
                .executeAsync();
    }

    @Override
    public int learnChunksCount(RequestParameters requestParameters) {
        return dslContext.selectCount().from(LEARN_STATISTIC)
                .where(LEARN_STATISTIC.REQUEST.eq(zipParameters(requestParameters)))
                .fetchOne(0, int.class);
    }

    @Override
    public void saveDiscreteDistribution(Measurement measurement, RequestParameters requestParameters, List<Pair<Integer, Double>> deviation) {
        final String key = zipParameters(requestParameters);
        final List<ResponseCodeDistributionRecord> values = deviation.stream().map(v -> new ResponseCodeDistributionRecord(key, v.getKey(), v.getValue())).collect(Collectors.toList());
        dslContext.insertInto(RESPONSE_CODE_DISTRIBUTION).values(values).executeAsync();
    }

    @Override
    public List<Pair<Integer, Double>> getDiscreteDistribution(Measurement measurement, RequestParameters requestParameters) {
        if (!measurement.equals(Measurement.RESPONSE_CODE)) {
            throw new UnsupportedOperationException("Unknown discrete distribution " + measurement);
        }

        Record2<Integer, Double>[] result = dslContext.select(RESPONSE_CODE_DISTRIBUTION.VALUE, RESPONSE_CODE_DISTRIBUTION.PROBABILITY)
                .from(RESPONSE_CODE_DISTRIBUTION)
                .where(RESPONSE_CODE_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                .fetchArray();
        return Arrays.stream(result)
                .map(resRecord -> new ImmutablePair<>(resRecord.component1(), resRecord.component2()))
                .collect(Collectors.toList());
    }

    @Override
    public void saveDistributionParameters(Measurement measurement, RequestParameters requestParameters, double mathExpectation, double variance) {
        final String key = zipParameters(requestParameters);
        switch (measurement) {
            case RESPONSE_SIZE:
                dslContext.insertInto(RESPONSE_SIZE_DISTRIBUTION)
                        .values(new ResponseSizeDistributionRecord(key, mathExpectation, variance))
                        .executeAsync();
                break;
            case HTML_TAGS_COUNT:
                dslContext.insertInto(TAGS_COUNT_DISTRIBUTION)
                        .values(new TagsCountDistributionRecord(key, mathExpectation, variance))
                        .executeAsync();
                break;
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }

    @Override
    public Pair<Double, Double> getDistributionParameters(Measurement measurement, RequestParameters requestParameters) {
        switch (measurement) {
            case RESPONSE_SIZE:
                ResponseSizeDistributionRecord res1 = dslContext.selectFrom(RESPONSE_SIZE_DISTRIBUTION)
                        .where(RESPONSE_SIZE_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                        .fetchOne();
                return new ImmutablePair<>(res1.getMathExpectation(), res1.getVariance());
            case HTML_TAGS_COUNT:
                TagsCountDistributionRecord res2 = dslContext.selectFrom(TAGS_COUNT_DISTRIBUTION)
                        .where(TAGS_COUNT_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                        .fetchOne();
                return new ImmutablePair<>(res2.getMathExpectation(), res2.getVariance());
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }


    private String zipParameters(RequestParameters requestParameters) {
        return requestParameters.getHttpMethod() + "#" + requestParameters.getPath() + "#" + requestParameters.getParams();
    }
}
