package tpfinal.scrims.demo.domain.model.factory;

import tpfinal.scrims.demo.domain.model.Observer;


/**
 * Implementación del patrón Abstract Factory.
 * Produce los distintos canales de notificación (Email, Push, etc.)
 */
public class FactoryProd implements NotifierFactory {

    @Override
    public Observer crearEmail() {
        return new EmailNotifier();
    }

    @Override
    public Observer crearPush() {
        return new PushNotifier();
    }
}
