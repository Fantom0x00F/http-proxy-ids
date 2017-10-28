package watcher;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.*;

final class TrollResponseBuilder {

    private static final String htmlContent = "<html>" +
            "<body>" +
            "<img src=\"http://i0.kym-cdn.com/photos/images/newsfeed/000/096/044/trollface.jpg\">" +
            "<br/>AHAHAHAHAH you can't hack me" +
            "</body>" +
            "</html>";

    private TrollResponseBuilder() {
    }

    static HttpObject trollResponse() {
        ByteBuf buffer = Unpooled.wrappedBuffer(htmlContent.getBytes());
        HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, buffer);
        HttpHeaders.setContentLength(response, buffer.readableBytes());
        HttpHeaders.setHeader(response, HttpHeaders.Names.CONTENT_TYPE, "text/html");
        return response;
    }

}
