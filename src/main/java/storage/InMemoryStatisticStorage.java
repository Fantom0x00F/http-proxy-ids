package storage;

import request.RequestParameters;
import statistic.ResponseStatisticRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryStatisticStorage implements IStatisticStorage {

    private ConcurrentMap<Key, List<ResponseStatisticRow>> statistic = new ConcurrentHashMap<>();

    @Override
    public void save(RequestParameters requestParameters, ResponseStatisticRow data) {
        Key key = new Key(requestParameters);
        statistic.putIfAbsent(key, new ArrayList<>());
        statistic.get(key).add(data);
    }

    @Override
    public List<ResponseStatisticRow> getStatistic(RequestParameters requestParameters) {
        return statistic.getOrDefault(new Key(requestParameters), Collections.emptyList());
    }

    @Override
    public void clear() {
        statistic.clear();
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
