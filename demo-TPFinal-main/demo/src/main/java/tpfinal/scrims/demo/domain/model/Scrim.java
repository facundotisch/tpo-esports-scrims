package tpfinal.scrims.demo.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tpfinal.scrims.demo.domain.state.*;
import tpfinal.scrims.*;
import tpfinal.scrims.demo.domain.adapter.*;

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
    private EstrategiaMatchmaking estrategia;
    private List<Usuario> jugadores = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Scrim() {
        this.estado = new EstadoBuscandoJugadores();
    }

    // Observer
    public void agregarObserver(Observer obs) { observers.add(obs); }
    public void notificarCambio(String evento) {
        System.out.println("[OBSERVER] Notificando cambio: " + evento);
        for (Observer o : observers) {
            o.update(evento);
        }
    }

    // State
    public void agregarJugador(Usuario u) { estado.agregarJugador(this, u); }
    public void confirmarJugador(Usuario u) { estado.confirmarJugador(this, u); }
    public void setEstado(ScrimState nuevo) {
        this.estado = nuevo;
        notificarCambio("Estado: " + nuevo.getClass().getSimpleName());
    }
    public ScrimState getEstado() { return estado; }

    // Strategy
    public void setEstrategia(EstrategiaMatchmaking estrategia) { this.estrategia = estrategia; }
    public void emparejar() {
        if (estrategia != null)
            estrategia.emparejar(this);
        else
            System.out.println("[WARN] No hay estrategia asignada al scrim.");
    }

    // Command (opcional)
    public void asignarRol(Usuario u, String rol) {
        System.out.println("Jugador " + u.getNombre() + " asignado al rol: " + rol);
    }

    // Getters y setters
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
