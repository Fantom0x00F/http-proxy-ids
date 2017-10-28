package request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestParameters implements Serializable {

    final String uri;

    List<String> params = new ArrayList<String>();
    byte[] requestContent;
    String httpMethod;

    RequestParameters(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getParams() {
        return params;
    }

    public byte[] getRequestContent() {
        return requestContent;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    @Override
    public String toString() {
        return "RequestParameters{" +
                "uri='" + uri + '\'' +
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

        return uri.equals(that.uri) &&
                params.equals(that.params) &&
                httpMethod.equals(that.httpMethod);
    }

    @Override
    public int hashCode() {
        int result = uri.hashCode();
        result = 31 * result + params.hashCode();
        result = 31 * result + httpMethod.hashCode();
        return result;
    }
}
