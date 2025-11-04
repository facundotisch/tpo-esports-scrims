package tpfinal.scrims.demo.domain.model.patterns;

/**
 * OBSERVER (modo compatible): interfaz de notificación desacoplada.
 * No reemplaza nada de lo existente. Opcional de usar desde servicios/controladores.
 */
public interface NotificationObserver {
    void update(String mensaje);
}
