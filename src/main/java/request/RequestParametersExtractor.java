package request;

import io.netty.buffer.ByteBuf;
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


        ByteBuf content = request.content().copy();
        byte[] data = new byte[content.readableBytes()];
        content.readBytes(data);
        requestParameters.requestContent = data;

        requestParameters.httpMethod = request.getMethod().toString();

        return requestParameters;
    }

}
