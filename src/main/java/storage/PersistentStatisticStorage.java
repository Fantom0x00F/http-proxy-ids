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
import storage.entities.reverse_proxy.tables.records.KeywordsCountDistributionRecord;
import storage.entities.reverse_proxy.tables.records.LatencyDistributionRecord;
import storage.entities.reverse_proxy.tables.records.ResponseCodeDistributionRecord;
import storage.entities.reverse_proxy.tables.records.ResponseSizeDistributionRecord;

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
                        LEARN_STATISTIC.HTML_TAGS_COUNT,
                        LEARN_STATISTIC.LATENCY)
                .values(zipParameters(requestParameters),
                        data.responseCode,
                        data.responseSize,
                        data.keywordsCount,
                        data.latencyInSec)
                .execute();
    }

    @Override
    public List<ResponseStatisticRow> getLearnChunk(RequestParameters requestParameters) {
        return Arrays.stream(dslContext.selectFrom(LEARN_STATISTIC).fetchArray())
                .map(stRecord -> new ResponseStatisticRow(stRecord.getCode(), stRecord.getSize(), stRecord.getHtmlTagsCount(), stRecord.getLatency()))
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
    public void saveDiscreteDistribution(Measurement measurement, RequestParameters requestParameters, List<Pair<Integer, Double>> distribution) {
        final String key = zipParameters(requestParameters);
        final List<ResponseCodeDistributionRecord> values = distribution.stream().map(v -> new ResponseCodeDistributionRecord(key, v.getKey(), v.getValue())).collect(Collectors.toList());
        dslContext.batchInsert(values).execute();
    }

    @Override
    public List<Pair<Integer, Double>> getDiscreteDistribution(Measurement measurement, RequestParameters requestParameters) {
        if (!measurement.equals(Measurement.response_code)) {
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
            case response_size:
                dslContext.insertInto(RESPONSE_SIZE_DISTRIBUTION)
                        .values(key, mathExpectation, variance)
                        .execute();
                break;
            case keywords_count:
                dslContext.insertInto(KEYWORDS_COUNT_DISTRIBUTION)
                        .values(key, mathExpectation, variance)
                        .execute();
                break;
            case latency:
                dslContext.insertInto(LATENCY_DISTRIBUTION)
                        .values(key, mathExpectation, variance)
                        .execute();
                break;
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }

    @Override
    public Pair<Double, Double> getDistributionParameters(Measurement measurement, RequestParameters requestParameters) {
        switch (measurement) {
            case response_size:
                ResponseSizeDistributionRecord res1 = dslContext.selectFrom(RESPONSE_SIZE_DISTRIBUTION)
                        .where(RESPONSE_SIZE_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                        .fetchOne();
                return new ImmutablePair<>(res1.getMathExpectation(), res1.getVariance());
            case keywords_count:
                KeywordsCountDistributionRecord res2 = dslContext.selectFrom(KEYWORDS_COUNT_DISTRIBUTION)
                        .where(KEYWORDS_COUNT_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                        .fetchOne();
                return new ImmutablePair<>(res2.getMathExpectation(), res2.getVariance());
            case latency:
                LatencyDistributionRecord res3 = dslContext.selectFrom(LATENCY_DISTRIBUTION)
                        .where(LATENCY_DISTRIBUTION.REQUEST.eq(zipParameters(requestParameters)))
                        .fetchOne();
                return new ImmutablePair<>(res3.getMathExpectation(), res3.getVariance());
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }


    private String zipParameters(RequestParameters requestParameters) {
        return requestParameters.getHttpMethod() + "#" + requestParameters.getPath() + "#" + requestParameters.getParams();
    }
}
