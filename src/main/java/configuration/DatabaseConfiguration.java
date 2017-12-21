package configuration;

public class DatabaseConfiguration {
    private String connection_url;
    private String user;
    private String password;

    public String getConnection_url() {
        return connection_url;
    }

    public void setConnection_url(String connection_url) {
        this.connection_url = connection_url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
