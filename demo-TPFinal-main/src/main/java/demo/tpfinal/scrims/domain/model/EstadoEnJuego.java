package demo.tpfinal.scrims.domain.model;

public class EstadoEnJuego implements ScrimState {
    @Override
    public void agregarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("No se pueden agregar jugadores mientras el scrim está en juego.");
    }
    @Override
    public void confirmarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("Ya está en juego.");
    }
}
