package tpfinal.scrims.demo;

import tpfinal.scrims.demo.domain.model.*;
import tpfinal.scrims.demo.domain.model.factory.FactoryProd;
import java.time.LocalDate;

public class TestObserverFactory {
    public static void main(String[] args) {
        System.out.println("=== TEST OBSERVER + FACTORY ===");

        Scrim scrim = new ScrimBuilder()
                .juego("CS2")
                .formato("5v5")
                .rango(5,15)
                .region("EU")
                .latencia(60)
                .fecha(LocalDate.now())
                .build();

        FactoryProd factory = new FactoryProd();
        scrim.agregarObserver(factory.crearEmail());
        scrim.agregarObserver(factory.crearPush());
    }
}
