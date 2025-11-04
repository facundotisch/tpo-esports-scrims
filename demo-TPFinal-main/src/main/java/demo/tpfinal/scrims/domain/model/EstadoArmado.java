package demo.tpfinal.scrims.domain.model;

public class EstadoArmado implements ScrimState {
    @Override
    public void agregarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("El scrim ya está armado. No se pueden agregar más jugadores.");
    }
    @Override
    public void confirmarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("Jugador confirmado.");
        scrim.setEstado(new EstadoEnJuego());
    }
}
