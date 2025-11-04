package tpfinal.scrims.demo.domain.state;

import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Usuario;

public interface ScrimState {
    public String agregarJugador(Scrim scrim, Usuario j);
    public String confirmarJugador(Scrim scrim, Usuario j);
}
