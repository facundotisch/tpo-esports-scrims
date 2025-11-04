package tpfinal.scrims.demo.domain.model.patterns;

public class EmailNotifier implements NotificationObserver {
    @Override public void update(String mensaje) {
        System.out.println("📧 email: " + mensaje);
    }
}
