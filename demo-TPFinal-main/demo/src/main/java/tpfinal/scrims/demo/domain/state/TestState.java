package tpfinal.scrims.demo.domain.state;


import tpfinal.scrims.demo.domain.model.*;
import tpfinal.scrims.demo.domain.*;

public class TestState {
    public static void main(String[] args) {
        Scrim scrim = new Scrim();
        scrim.setEstado(new EstadoBuscandoJugadores());

        System.out.println("=== TEST STATE ===");
        scrim.getEstado().avanzar(scrim);
        scrim.getEstado().avanzar(scrim);
        scrim.getEstado().avanzar(scrim);
    }
}
