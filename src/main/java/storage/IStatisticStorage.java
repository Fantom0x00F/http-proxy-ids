package storage;

import org.apache.commons.lang3.tuple.Pair;
import request.RequestParameters;
import statistic.Measurement;
import statistic.ResponseStatisticRow;

import java.util.List;

public interface IStatisticStorage {

    void saveLearnChunk(RequestParameters requestParameters, ResponseStatisticRow data);

    List<ResponseStatisticRow> getLearnChunk(RequestParameters requestParameters);

    void eraseLearnChunks(RequestParameters requestParameters);

    int learnChunksCount(RequestParameters requestParameters);

    void saveDiscreteDistribution(Measurement measurement, RequestParameters requestParameters, List<Pair<Integer, Double>> deviation);

    List<Pair<Integer, Double>> getDiscreteDistribution(Measurement measurement, RequestParameters requestParameters);

    void saveDistributionParameters(Measurement measurement, RequestParameters requestParameters, double mathExpectation, double variance);

    Pair<Double, Double> getDistributionParameters(Measurement measurement, RequestParameters requestParameters);

}
