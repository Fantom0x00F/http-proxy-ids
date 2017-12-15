package storage;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import request.RequestParameters;
import statistic.ResponseStatisticRow;
import storage.entities.reverse_proxy.Tables;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersistentStatisticStorage implements IStatisticStorage {

    private final DSLContext dslContext;

    public PersistentStatisticStorage(Connection connection, SQLDialect dialect) {
        dslContext = DSL.using(connection, dialect);
    }

    @Override
    public void save(RequestParameters requestParameters, ResponseStatisticRow data) {
        dslContext.insertInto(Tables.LEARN_STATISTIC)
                .columns(Tables.LEARN_STATISTIC.REQUEST,
                        Tables.LEARN_STATISTIC.CODE,
                        Tables.LEARN_STATISTIC.SIZE,
                        Tables.LEARN_STATISTIC.HTML_TAGS_COUNT)
                .values(zipParameters(requestParameters),
                        data.responseCode,
                        data.responseSize,
                        data.htmlTagsCount)
                .execute();
    }

    @Override
    public List<ResponseStatisticRow> getStatistic(RequestParameters requestParameters) {
        return Arrays.stream(dslContext.selectFrom(Tables.LEARN_STATISTIC).fetchArray())
                .map(stRecord -> new ResponseStatisticRow(stRecord.getCode(), stRecord.getSize(), stRecord.getHtmlTagsCount()))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {

    }

    private String zipParameters(RequestParameters requestParameters) {
        return requestParameters.getHttpMethod() + "#" + requestParameters.getPath() + "#" + requestParameters.getParams();
    }
}
