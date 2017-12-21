package configuration;

import statistic.Measurement;

import java.util.Map;

public class Configuration {

    private int port;
    private String backend_host;
    private int backend_port;

    private DatabaseConfiguration database;
    private Map<Measurement, Double> thresholds;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBackend_host() {
        return backend_host;
    }

    public void setBackend_host(String backend_host) {
        this.backend_host = backend_host;
    }

    public int getBackend_port() {
        return backend_port;
    }

    public void setBackend_port(int backend_port) {
        this.backend_port = backend_port;
    }

    public DatabaseConfiguration getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfiguration database) {
        this.database = database;
    }

    public Map<Measurement, Double> getThresholds() {
        return thresholds;
    }

    public void setThresholds(Map<Measurement, Double> thresholds) {
        this.thresholds = thresholds;
    }
}
