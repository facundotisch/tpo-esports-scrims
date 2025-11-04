package tpfinal.scrims.demo.domain.model;

public class EstadoBuscandoJugadores implements ScrimState {
    @Override
    public void agregarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("Jugador agregado al scrim.");
        scrim.setEstado(new EstadoArmado());
    }
    @Override
    public void confirmarJugador(Scrim scrim, Usuario jugador) {
        System.out.println("No se puede confirmar todavía, el lobby no está armado.");
    }
}
