package request;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public final class RequestParametersExtractor {

    private RequestParametersExtractor() {
    }

    public static RequestParameters extract(FullHttpRequest request) throws URISyntaxException, UnsupportedEncodingException {
        String uri = request.getUri();

        String path;
        String uriParams = "";
        int q = uri.indexOf("?");
        if (q != -1) {
            path = uri.substring(0, q);
            uriParams = uri.substring(q + 1, uri.length());
        } else {
            path = uri;
        }

        RequestParameters requestParameters = new RequestParameters(path);

        List<NameValuePair> params = URLEncodedUtils.parse(uriParams, Charset.forName("UTF-8"));

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
