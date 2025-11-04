package demo.tpfinal.scrims.domain.model;

public class Jugador {
    private String nombre;
    private double mmr;
    private double latencia;

    public Jugador(String nombre, double mmr, double latencia) {
        this.nombre = nombre;
        this.mmr = mmr;
        this.latencia = latencia;
    }

    public String getNombre() { return nombre; }
    public double getMmr() { return mmr; }
    public double getLatencia() { return latencia; }
}
