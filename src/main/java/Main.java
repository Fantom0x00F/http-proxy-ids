import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.*;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.littleshoot.proxy.mitm.RootCertificateException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Queue;

public class Main {

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
                    public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
                        return new HttpFiltersAdapter(originalRequest) {

                            @Override
                            public HttpResponse clientToProxyRequest(HttpObject httpObject) {
                                System.out.println("======================CLIENT TO PROXY=========================");
                                System.out.println(httpObject);
                                return null;
                            }

                            @Override
                            public HttpObject serverToProxyResponse(HttpObject httpObject) {
                                System.out.println("**********************SERVER TO PROXY************************");
                                System.out.println(httpObject);
                                return httpObject;
                            }
                        };
                    }
                })
                .start();
    }


}
