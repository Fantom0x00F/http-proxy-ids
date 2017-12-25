import analyser.Analyser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.Configuration;
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

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Function;

public class Main {

    @Parameter(names = {"--configFile", "-cF"}, description = "Configuration file path", required = true)
    private String configurationFilePath = null;

    private Configuration configuration;

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
        readConfiguration();

        final Analyser analyser = new Analyser();
        analyser.setAlertNotificator(new CommandLineNotification());
        analyser.setStatisticStorage(buildStatisticStorage());
        analyser.setThresholds(configuration.getThresholds());
        analyser.setKeywords(configuration.getKeywords());

        startServer((request) -> new WatcherFilter(analyser, request));
    }

    private IStatisticStorage buildStatisticStorage() throws Exception {
        String user = configuration.getDatabase().getUser();
        String password = configuration.getDatabase().getPassword();
        String url = configuration.getDatabase().getConnection_url();
        String driver = "com.mysql.cj.jdbc.Driver";

        Class.forName(driver).newInstance();
        Connection connection = DriverManager.getConnection(url, user, password);

        return new PersistentStatisticStorage(connection, SQLDialect.MYSQL);
    }


    private void startServer(Function<HttpRequest, HttpFilters> filterBuilder) {
        DefaultHttpProxyServer.bootstrap()
                .withPort(configuration.getPort())
                .withChainProxyManager((httpRequest, chainedProxies) -> chainedProxies.add(new ChainedProxyAdapter() {
                    @Override
                    public InetSocketAddress getChainedProxyAddress() {
                        return new InetSocketAddress(configuration.getBackend_host(), configuration.getBackend_port());
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

    private void readConfiguration() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        configuration = mapper.readValue(new File(configurationFilePath), Configuration.class);
    }

}
