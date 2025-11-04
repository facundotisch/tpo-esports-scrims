package tpfinal.scrims.demo.domain.model;

public class EstadoFinalizado implements ScrimState {
    @Override
    public void agregarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("Scrim finalizado, no se pueden agregar jugadores.");
    }
    @Override
    public void confirmarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("Scrim ya finalizado.");
    }
}
