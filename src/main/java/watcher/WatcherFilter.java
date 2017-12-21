package watcher;

import analyser.Analyser;
import io.netty.handler.codec.http.*;
import org.littleshoot.proxy.HttpFiltersAdapter;
import request.RequestParameters;
import request.RequestParametersExtractor;
import response.ResponseData;
import response.ResponseDataExtractor;

public class WatcherFilter extends HttpFiltersAdapter {

    private RequestParameters requestParameters;
    private final Analyser analyser;
    private final HttpObject trollResponse = TrollResponseBuilder.trollResponse();
    private long requestStartTime;

    public WatcherFilter(Analyser analyser, HttpRequest originalRequest) {
        super(originalRequest);
        this.analyser = analyser;
    }

    @Override
    public HttpResponse clientToProxyRequest(HttpObject httpObject) {
        try {
            assert httpObject instanceof FullHttpRequest;
            requestStartTime = System.nanoTime();
            requestParameters = RequestParametersExtractor.extract((FullHttpRequest) httpObject);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HttpObject serverToProxyResponse(HttpObject httpObject) {
        boolean correctResponse = false;
        if (requestParameters != null) {
            ResponseData responseData = ResponseDataExtractor.extract((FullHttpResponse) httpObject);
            responseData.latencyInSec = (int) ((System.nanoTime() - requestStartTime) / 1e9);
            correctResponse = analyser.processRequest(requestParameters, responseData);
        }

        return (correctResponse) ? httpObject : trollResponse;
    }
}
