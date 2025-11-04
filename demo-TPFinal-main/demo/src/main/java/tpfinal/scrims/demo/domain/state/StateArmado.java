package tpfinal.scrims.demo.domain.state;


import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Usuario;

public class StateArmado implements ScrimState {

    @Override
    public String agregarJugador(Scrim scrim, Usuario j) {
        return "se agrego al jugador a la scrim";
    }

    @Override
    public String confirmarJugador(Scrim scrim, Usuario j) {
        return "se confirmo al jugador a la scrim";
    }
}
