package response;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpResponse;

public final class ResponseDataExtractor {

    private ResponseDataExtractor() {
    }

    public static ResponseData extract(FullHttpResponse response) {
        ResponseData responseData = new ResponseData();

        responseData.responseCode = response.getStatus().code();

        ByteBuf content = response.content().copy();
        byte[] data = new byte[content.readableBytes()];
        content.readBytes(data);
        responseData.responseContent = data;

        String contentTypeHeader = response.headers().get("Content-Type");
        if (contentTypeHeader != null) {
            responseData.contentType = contentTypeHeader;
        }

        return responseData;
    }
}
