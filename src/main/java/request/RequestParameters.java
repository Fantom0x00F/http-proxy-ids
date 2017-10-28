package request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestParameters implements Serializable {

    private final String path;

    List<String> params = new ArrayList<>();
    byte[] requestContent;
    String httpMethod;

    RequestParameters(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public List<String> getParams() {
        return params;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    @Override
    public String toString() {
        return "RequestParameters{" +
                "path='" + path + '\'' +
                ", params=" + params +
                ", requestContent=" + Arrays.toString(requestContent) +
                ", httpMethod='" + httpMethod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestParameters that = (RequestParameters) o;

        return path.equals(that.path) &&
                params.equals(that.params) &&
                httpMethod.equals(that.httpMethod);
    }

    @Override
    public int hashCode() {
        int result = path.hashCode();
        result = 31 * result + params.hashCode();
        result = 31 * result + httpMethod.hashCode();
        return result;
    }
}
