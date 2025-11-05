package tpfinal.scrims.demo;

import tpfinal.scrims.demo.domain.model.*;
import tpfinal.scrims.demo.*;

public class TestStrategy {
    public static void main(String[] args) {
        Scrim scrim = new ScrimBuilder()
                .juego("Valorant")
                .formato("5v5")
                .region("LATAM")
                .rango(1, 10)
                .latencia(80)
                .build();

        System.out.println("=== TEST STRATEGY ===");
        scrim.emparejar(new EstrategiaPorMMR());
        scrim.emparejar(new EstrategiaPorLatencia());
    }
}
