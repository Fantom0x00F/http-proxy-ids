package storage;

import request.RequestParameters;
import statistic.ResponseStatisticRow;

import java.util.List;

public interface IStatisticStorage {

    void save(RequestParameters requestParameters, ResponseStatisticRow data);

    List<ResponseStatisticRow> getStatistic(RequestParameters requestParameters);

    void clear();

}
