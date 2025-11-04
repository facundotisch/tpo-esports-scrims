package tpfinal.scrims.demo;

import tpfinal.scrims.demo.domain.model.*;
import java.time.LocalDate;

public class MainDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO SCRIMS (Patrones) ===");

        Scrim scrim = new ScrimBuilder()
                .juego("Valorant")
                .formato("5v5")
                .rango(1,10)
                .region("LATAM")
                .latencia(80)
                .fecha(LocalDate.now())
                .build();

        FactoryProd factory = new FactoryProd();
        scrim.agregarObserver(factory.crearEmail());
        scrim.agregarObserver(factory.crearPush());

        Usuario jugador1 = new Usuario("Facu");
        scrim.agregarJugador(jugador1);
        scrim.confirmarJugador(jugador1);
        scrim.setEstado(new EstadoFinalizado());
        scrim.confirmarJugador(jugador1);

        System.out.println("=== FIN DEMO ===");
    }
}
