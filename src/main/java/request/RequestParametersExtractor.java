package request;

import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Map;

public final class RequestParametersExtractor {

    private RequestParametersExtractor() {
    }

    public static RequestParameters extract(FullHttpRequest request) {
        RequestParameters requestParameters = new RequestParameters(request.getUri());

        for (Map.Entry<String, String> header : request.headers()) {
            requestParameters.headers.add(header.getKey() + " " + header.getValue());
        }

        requestParameters.requestContent = request.content().array().clone();
        requestParameters.httpMethod = request.getMethod().toString();

        return requestParameters;
    }

}
