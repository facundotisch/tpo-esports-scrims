package tpfinal.scrims.demo.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Scrim {
    private String id;
    private String juego;
    private String formato;
    private double rangoMin;
    private double rangoMax;
    private String region;
    private double latenciaMax;
    private LocalDate fecha;
    private ScrimState estado;
    private List<Usuario> jugadores = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Scrim() {
        this.estado = new EstadoBuscandoJugadores();
    }

    public void agregarObserver(Observer obs) { observers.add(obs); }
    public void notificarCambio(String evento) {
        observers.forEach(o -> o.update(evento));
    }

    public void agregarJugador(Usuario u) { estado.agregarJugador(this, u); }
    public void confirmarJugador(Usuario u) { estado.confirmarJugador(this, u); }
    public void setEstado(ScrimState nuevo) {
        this.estado = nuevo;
        notificarCambio("Estado: " + nuevo.getClass().getSimpleName());
    }

    public String getJuego() { return juego; }
    public void setJuego(String juego) { this.juego = juego; }
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public double getRangoMin() { return rangoMin; }
    public void setRangoMin(double rangoMin) { this.rangoMin = rangoMin; }
    public double getRangoMax() { return rangoMax; }
    public void setRangoMax(double rangoMax) { this.rangoMax = rangoMax; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public double getLatenciaMax() { return latenciaMax; }
    public void setLatenciaMax(double latenciaMax) { this.latenciaMax = latenciaMax; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
