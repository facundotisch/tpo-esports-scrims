package tpfinal.scrims.demo.domain.model.patterns;

public class ProdNotifierFactory implements NotifierFactory {
    @Override public NotificationObserver email() { return new EmailNotifier(); }
    @Override public NotificationObserver push()  { return new PushNotifier(); }
}
