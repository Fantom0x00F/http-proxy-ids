package notification;

public interface INotificator {

    void error(String message);

    void warning(String message);

    void info(String message);
}
