package demo.tpfinal.scrims.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public interface EstrategiaMatchmaking {
    List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims);
}

class MatchmakingPorMMR implements EstrategiaMatchmaking {
    @Override
    public List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims) {
        return scrims.stream()
            .filter(s -> jugador.getMmr() >= s.getRangoMin() && jugador.getMmr() <= s.getRangoMax())
            .collect(Collectors.toList());
    }
}

class MatchmakingPorLatencia implements EstrategiaMatchmaking {
    @Override
    public List<Scrim> emparejar(Jugador jugador, List<Scrim> scrims) {
        return scrims.stream()
            .filter(s -> jugador.getLatencia() <= s.getLatenciaMax())
            .collect(Collectors.toList());
    }
}
