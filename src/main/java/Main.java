import analyser.Analyser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.littleshoot.proxy.ChainedProxyAdapter;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersAdapter;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.littleshoot.proxy.mitm.RootCertificateException;
import request.RequestParameters;
import request.RequestParametersExtractor;
import response.ResponseDataExtractor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    @Parameter(names = {"--backendHost", "-bH"}, description = "Back host", required = true)
    private String BACKEND_HOST = "contest.uni-smr.ac.ru";

    @Parameter(names = {"--backendPort", "-bP"}, description = "Back port", required = true)
    private int BACKEND_PORT = 80;

    @Parameter(names = {"--port", "-p"}, description = "Used port")
    private int PORT = 8080;

    private static final int MAXIMUM_REQUEST_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int MAXIMUM_RESPONSE_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int REQUIRED_REQUESTS_FOR_TRAINING = 10;
    private static AtomicInteger trainingRequestsCount = new AtomicInteger(0);

    public static void main(String[] args) throws IOException, RootCertificateException {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    private void run() {
        final Analyser analyser = new Analyser();

        DefaultHttpProxyServer.bootstrap()
                .withPort(PORT)
                .withChainProxyManager((httpRequest, chainedProxies) -> chainedProxies.add(new ChainedProxyAdapter() {
                    @Override
                    public InetSocketAddress getChainedProxyAddress() {
                        return new InetSocketAddress(BACKEND_HOST, BACKEND_PORT);
                    }
                }))
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
