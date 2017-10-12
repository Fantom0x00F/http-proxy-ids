package storage;

import request.RequestParameters;
import statistic.ResponseStatisticRow;

public interface IStatisticStorage {

    void save(RequestParameters requestParameters, ResponseStatisticRow data);

    void clear();

}
