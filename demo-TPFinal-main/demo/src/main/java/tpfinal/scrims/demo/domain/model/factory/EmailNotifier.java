package tpfinal.scrims.demo.domain.model.factory;

import tpfinal.scrims.demo.domain.model.Observer;


public class EmailNotifier implements Observer {
    @Override
    public void update(String mensaje) {
        System.out.println("[EMAIL] " + mensaje);
    }
}
