import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.littleshoot.proxy.*;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.littleshoot.proxy.mitm.RootCertificateException;
import request.RequestParametersExtractor;
import response.ResponseDataExtractor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Queue;

public class Main {

    private static final int MAXIMUM_REQUEST_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int MAXIMUM_RESPONSE_SIZE_IN_BYTES = 10 * 1024 * 1024;

    public static void main(String[] args) throws IOException, RootCertificateException {
        DefaultHttpProxyServer.bootstrap()
                .withPort(8880)
                .withChainProxyManager(new ChainedProxyManager() {
                    public void lookupChainedProxies(HttpRequest httpRequest, Queue<ChainedProxy> chainedProxies) {
                        chainedProxies.add(new ChainedProxyAdapter() {
                            @Override
                            public InetSocketAddress getChainedProxyAddress() {
                                return new InetSocketAddress("contest.uni-smr.ac.ru", 80);
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

                            @Override
                            public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                try {
                                    assert httpObject instanceof FullHttpRequest;
                                    System.out.println(RequestParametersExtractor.extract((FullHttpRequest) httpObject));
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }

                            @Override
                            public HttpObject serverToProxyResponse(HttpObject httpObject) {
                                try {
                                    System.out.println(ResponseDataExtractor.extract((FullHttpResponse) httpObject));
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
