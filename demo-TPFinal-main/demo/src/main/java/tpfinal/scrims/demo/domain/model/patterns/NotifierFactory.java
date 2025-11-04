package tpfinal.scrims.demo.domain.model.patterns;

/**
 * ABSTRACT FACTORY: contrato para crear canales de notificación.
 * Add-only. No requiere cambios en el dominio actual.
 */
public interface NotifierFactory {
    NotificationObserver email();
    NotificationObserver push();
}
