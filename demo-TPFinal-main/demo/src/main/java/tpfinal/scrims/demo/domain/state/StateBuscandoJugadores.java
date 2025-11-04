package tpfinal.scrims.demo.domain.state;

import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Usuario;

public class StateBuscandoJugadores implements ScrimState{
    @Override
    public String agregarJugador(Scrim scrim, Usuario j) {
        return "";
    }

    @Override
    public String confirmarJugador(Scrim scrim, Usuario j) {
        return "";
    }
}
