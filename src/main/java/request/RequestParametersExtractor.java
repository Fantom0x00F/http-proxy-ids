package request;

import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.List;

public final class RequestParametersExtractor {

    private RequestParametersExtractor() {
    }

    public static RequestParameters extract(FullHttpRequest request) {
        RequestParameters requestParameters = new RequestParameters(request.getUri());

        List<NameValuePair> params = URLEncodedUtils.parse(request.getUri(), Charset.forName("UTF-8"));

        for (NameValuePair param : params) {
            requestParameters.params.add(param.getName());
        }

        requestParameters.requestContent = request.content().array().clone();
        requestParameters.httpMethod = request.getMethod().toString();

        return requestParameters;
    }

}
