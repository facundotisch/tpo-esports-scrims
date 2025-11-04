package demo.tpfinal.scrims.domain.model;

import java.time.LocalDate;

public class ScrimBuilder {
    private Scrim scrim = new Scrim();

    public ScrimBuilder juego(String j) { scrim.setJuego(j); return this; }
    public ScrimBuilder formato(String f) { scrim.setFormato(f); return this; }
    public ScrimBuilder rango(double min, double max) { scrim.setRangoMin(min); scrim.setRangoMax(max); return this; }
    public ScrimBuilder region(String r) { scrim.setRegion(r); return this; }
    public ScrimBuilder latencia(double l) { scrim.setLatenciaMax(l); return this; }
    public ScrimBuilder fecha(LocalDate d) { scrim.setFecha(d); return this; }

    public Scrim build() {
        if (scrim.getJuego() == null) throw new IllegalStateException("Debe definir un juego");
        return scrim;
    }
}
