package notification;

public class CommandLineNotification implements INotificator {

    @Override
    public void error(String message) {
        System.err.println(message);
    }

    @Override
    public void warning(String message) {
        System.out.println(message);
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }
}
