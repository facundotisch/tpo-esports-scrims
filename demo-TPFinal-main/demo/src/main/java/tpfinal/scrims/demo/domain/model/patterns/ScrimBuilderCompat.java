package tpfinal.scrims.demo.domain.model.patterns;

import java.time.LocalDate;

import tpfinal.scrims.demo.domain.model.Scrim;

/**
 * BUILDER compatible que usa los setters públicos de la clase existente Scrim.
 * No toca ni hereda de Scrim para evitar conflictos. Uso opcional desde servicios.
 */
public class ScrimBuilderCompat {
    private final Scrim scrim = new Scrim();

    public ScrimBuilderCompat juego(String v){ scrim.setJuego(v); return this; }
    public ScrimBuilderCompat formato(String v){ scrim.setFormato(v); return this; }
    public ScrimBuilderCompat rango(double min,double max){ scrim.setRangoMin(min); scrim.setRangoMax(max); return this; }
    public ScrimBuilderCompat region(String v){ scrim.setRegion(v); return this; }
    public ScrimBuilderCompat latencia(double v){ scrim.setLatenciaMax(v); return this; }
    public ScrimBuilderCompat fecha(LocalDate d){ scrim.setFecha(d); return this; }

    public Scrim build(){
        if (scrim.getJuego()==null || scrim.getJuego().isBlank())
            throw new IllegalStateException("debe definir juego");
        if (scrim.getRangoMin() > scrim.getRangoMax())
            throw new IllegalStateException("rangoMin no puede ser mayor a rangoMax");
        return scrim;
    }
}
