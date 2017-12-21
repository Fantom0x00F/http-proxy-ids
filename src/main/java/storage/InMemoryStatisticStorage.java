package storage;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import request.RequestParameters;
import statistic.Measurement;
import statistic.ResponseStatisticRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryStatisticStorage implements IStatisticStorage {

    private ConcurrentMap<Key, List<ResponseStatisticRow>> statistic = new ConcurrentHashMap<>();
    private ConcurrentMap<Key, List<Pair<Integer, Double>>> responseCodeDistribution = new ConcurrentHashMap<>();
    private ConcurrentMap<Key, Pair<Double, Double>> responseSizeDistributionParams = new ConcurrentHashMap<>();
    private ConcurrentMap<Key, Pair<Double, Double>> tagsCountDistributionParams = new ConcurrentHashMap<>();

    @Override
    public void saveLearnChunk(RequestParameters requestParameters, ResponseStatisticRow data) {
        Key key = key(requestParameters);
        statistic.putIfAbsent(key, new ArrayList<>());
        statistic.get(key).add(data);
    }

    @Override
    public List<ResponseStatisticRow> getLearnChunk(RequestParameters requestParameters) {
        return statistic.getOrDefault(key(requestParameters), Collections.emptyList());
    }

    @Override
    public void eraseLearnChunks(RequestParameters requestParameters) {
        statistic.put(key(requestParameters), new ArrayList<>());
    }

    @Override
    public int learnChunksCount(RequestParameters requestParameters) {
        return statistic.getOrDefault(requestParameters, Collections.emptyList()).size();
    }

    @Override
    public void saveDiscreteDistribution(Measurement measurement, RequestParameters requestParameters, List<Pair<Integer, Double>> distribution) {
        responseCodeDistribution.put(key(requestParameters), new ArrayList<>(distribution));
    }

    @Override
    public List<Pair<Integer, Double>> getDiscreteDistribution(Measurement measurement, RequestParameters requestParameters) {
        return responseCodeDistribution.getOrDefault(key(requestParameters), Collections.emptyList());
    }

    @Override
    public void saveDistributionParameters(Measurement measurement, RequestParameters requestParameters, double mathExpectation, double variance) {
        switch (measurement) {
            case response_size:
                responseSizeDistributionParams.put(key(requestParameters), ImmutablePair.of(mathExpectation, variance));
                break;
            case html_tags_count:
                tagsCountDistributionParams.put(key(requestParameters), ImmutablePair.of(mathExpectation, variance));
                break;
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }

    @Override
    public Pair<Double, Double> getDistributionParameters(Measurement measurement, RequestParameters requestParameters) {
        switch (measurement) {
            case response_size:
                return responseSizeDistributionParams.get(key(requestParameters));
            case html_tags_count:
                return tagsCountDistributionParams.get(key(requestParameters));
            default:
                throw new UnsupportedOperationException("Unknown distribution " + measurement);
        }
    }

    private Key key(RequestParameters requestParameters) {
        return new Key(requestParameters);
    }

    private class Key {

        final String path;
        final String httpMethod;
        final List<String> params;

        Key(RequestParameters requestParameters) {
            this.path = requestParameters.getPath();
            this.httpMethod = requestParameters.getHttpMethod();
            this.params = Collections.unmodifiableList(requestParameters.getParams());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            return path.equals(key.path) &&
                    httpMethod.equals(key.httpMethod) &&
                    params.equals(key.params);
        }

        @Override
        public int hashCode() {
            return Objects.hash(path, httpMethod, params);
        }
    }
}
