package tpfinal.scrims.demo.domain.model;

import tpfinal.scrims.demo.domain.model.factory.*;

public interface Observer { void update(String mensaje); }

public interface NotifierFactory {
    Observer crearEmail();
    Observer crearPush();
}

class FactoryProd implements NotifierFactory {
    @Override public Observer crearEmail() { return new NotificadorEmail(); }
    @Override public Observer crearPush() { return new NotificadorPush(); }
}

class NotificadorEmail implements Observer {
    @Override public void update(String mensaje) {
        System.out.println("📧 Email enviado: " + mensaje);
    }
}

class NotificadorPush implements Observer {
    @Override public void update(String mensaje) {
        System.out.println("📱 Notificación push: " + mensaje);
    }
}
