package tpfinal.scrims.demo.domain.model.patterns;

import java.util.List;
import java.util.stream.Collectors;

import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Jugador;

/**
 * STRATEGY: contrato para distintas formas de emparejar scrims.
 * 100% ADD-ONLY. No modifica clases existentes.
 */
public interface EstrategiaMatchmaking {
    List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims);
}

/** Empareja por MMR dentro del rango del scrim. */
class MatchmakingPorMMR implements EstrategiaMatchmaking {
    @Override
    public List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims) {
        return scrims.stream()
                .filter(s -> jugador.getMmr() >= s.getRangoMin() && jugador.getMmr() <= s.getRangoMax())
                .collect(Collectors.toList());
    }
}

/** Empareja por latencia máxima permitida por el scrim. */
class MatchmakingPorLatencia implements EstrategiaMatchmaking {
    @Override
    public List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims) {
        return scrims.stream()
                .filter(s -> jugador.getLatencia() <= s.getLatenciaMax())
                .collect(Collectors.toList());
    }
}
