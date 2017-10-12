import analyser.Analyser;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.littleshoot.proxy.*;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.littleshoot.proxy.mitm.RootCertificateException;
import request.RequestParameters;
import request.RequestParametersExtractor;
import response.ResponseDataExtractor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final String BACKEND_HOST = "contest.uni-smr.ac.ru";
    private static final int BACKEND_PORT = 80;

    private static final int MAXIMUM_REQUEST_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int MAXIMUM_RESPONSE_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int REQUIRED_REQUESTS_FOR_TRAINING = 10;
    private static AtomicInteger trainingRequestsCount = new AtomicInteger(0);

    public static void main(String[] args) throws IOException, RootCertificateException {
        final Analyser analyser = new Analyser();

        DefaultHttpProxyServer.bootstrap()
                .withPort(8880)
                .withChainProxyManager(new ChainedProxyManager() {
                    public void lookupChainedProxies(HttpRequest httpRequest, Queue<ChainedProxy> chainedProxies) {
                        chainedProxies.add(new ChainedProxyAdapter() {
                            @Override
                            public InetSocketAddress getChainedProxyAddress() {
                                return new InetSocketAddress(BACKEND_HOST, BACKEND_PORT);
                            }
                        });
                    }
                })
                .withAllowLocalOnly(false)
                .withAllowRequestToOriginServer(true)
                .withFiltersSource(new HttpFiltersSourceAdapter() {

                    @Override
                    public int getMaximumRequestBufferSizeInBytes() {
                        return MAXIMUM_REQUEST_SIZE_IN_BYTES;
                    }

                    @Override
                    public int getMaximumResponseBufferSizeInBytes() {
                        return MAXIMUM_RESPONSE_SIZE_IN_BYTES;
                    }

                    public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                        return new HttpFiltersAdapter(originalRequest) {
                            private RequestParameters requestParameters;

                            @Override
                            public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                try {
                                    assert httpObject instanceof FullHttpRequest;
                                    requestParameters = RequestParametersExtractor.extract((FullHttpRequest) httpObject);
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }

                            @Override
                            public HttpObject serverToProxyResponse(HttpObject httpObject) {
                                try {
                                    if (trainingRequestsCount.get() == 0) {
                                        analyser.startTraining();
                                    }

                                    analyser.processRequest(requestParameters, ResponseDataExtractor.extract((FullHttpResponse) httpObject));

                                    if (trainingRequestsCount.get() < REQUIRED_REQUESTS_FOR_TRAINING) {
                                        int trainingRequests = trainingRequestsCount.incrementAndGet();
                                        if (trainingRequests == REQUIRED_REQUESTS_FOR_TRAINING) {
                                            analyser.stopTraining();
                                        }
                                    }
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                                return httpObject;
                            }
                        };
                    }
                })
                .start();
    }

}
