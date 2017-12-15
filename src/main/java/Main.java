import analyser.Analyser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import notification.CommandLineNotification;
import org.jooq.SQLDialect;
import org.littleshoot.proxy.ChainedProxyAdapter;
import org.littleshoot.proxy.HttpFilters;
import org.littleshoot.proxy.HttpFiltersSourceAdapter;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import storage.IStatisticStorage;
import storage.PersistentStatisticStorage;
import watcher.WatcherFilter;

import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Function;

public class Main {

    @Parameter(names = {"--backendHost", "-bH"}, description = "Back host", required = true)
    private String BACKEND_HOST = "contest.uni-smr.ac.ru";

    @Parameter(names = {"--backendPort", "-bP"}, description = "Back port", required = true)
    private int BACKEND_PORT = 80;

    @Parameter(names = {"--port", "-p"}, description = "Used port")
    private int PORT = 8080;

    private static final int MAXIMUM_REQUEST_SIZE_IN_BYTES = 10 * 1024 * 1024;
    private static final int MAXIMUM_RESPONSE_SIZE_IN_BYTES = 10 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    private void run() throws Exception {
        final Analyser analyser = new Analyser();
        analyser.setAlertNotificator(new CommandLineNotification());
        analyser.setStatisticStorage(buildStatisticStorage());

        startServer((request) -> new WatcherFilter(analyser, request));
    }

    private IStatisticStorage buildStatisticStorage() throws Exception {
        String user = System.getProperty("jdbc.user");
        String password = System.getProperty("jdbc.password");
        String url = System.getProperty("jdbc.url");
        String driver = System.getProperty("jdbc.driver");

        Class.forName(driver).newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);

        return new PersistentStatisticStorage(connection, SQLDialect.MYSQL);
    }


    private void startServer(Function<HttpRequest, HttpFilters> filterBuilder) {
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
                        return filterBuilder.apply(originalRequest);
                    }
                })
                .start();
    }

}
