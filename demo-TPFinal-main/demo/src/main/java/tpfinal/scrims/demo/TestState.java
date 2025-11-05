package tpfinal.scrims.demo;

import tpfinal.scrims.demo.domain.model.*;
import tpfinal.scrims.demo.domain.state.*;

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
