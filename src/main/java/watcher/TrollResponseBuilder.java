package watcher;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.*;

final class TrollResponseBuilder {

    private TrollResponseBuilder() {
    }

    static HttpObject trollResponse() {
        ByteBuf buffer = Unpooled.wrappedBuffer("AHAHAHAHAH you can't hack me".getBytes());
        HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buffer);
        HttpHeaders.setContentLength(response, buffer.readableBytes());
        HttpHeaders.setHeader(response, HttpHeaders.Names.CONTENT_TYPE, "text/html");
        return response;
    }

}
