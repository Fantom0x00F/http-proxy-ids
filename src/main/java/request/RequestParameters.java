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

    @Override
    public String toString() {
        return "RequestParameters{" +
                "uri='" + uri + '\'' +
                ", params=" + params +
                ", requestContent=" + Arrays.toString(requestContent) +
                ", httpMethod='" + httpMethod + '\'' +
                '}';
    }
}
