package tpfinal.scrims.demo.domain.model.factory;

import tpfinal.scrims.demo.domain.model.Observer;

public class PushNotifier implements Observer {
    @Override
    public void update(String mensaje) {
        System.out.println("[PUSH] " + mensaje);
    }
}
