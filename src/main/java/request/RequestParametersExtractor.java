package request;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public final class RequestParametersExtractor {

    private RequestParametersExtractor() {
    }

    public static RequestParameters extract(FullHttpRequest request) throws URISyntaxException {
        String uri = request.getUri();
        URI urica = new URI(uri);

        RequestParameters requestParameters = new RequestParameters(urica.getPath());

        List<NameValuePair> params = URLEncodedUtils.parse(urica, Charset.forName("UTF-8"));

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
