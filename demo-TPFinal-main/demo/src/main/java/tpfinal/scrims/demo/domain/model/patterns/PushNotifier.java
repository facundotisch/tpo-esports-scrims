package tpfinal.scrims.demo.domain.model.patterns;

public class PushNotifier implements NotificationObserver {
    @Override public void update(String mensaje) {
        System.out.println("📱 push: " + mensaje);
    }
}
