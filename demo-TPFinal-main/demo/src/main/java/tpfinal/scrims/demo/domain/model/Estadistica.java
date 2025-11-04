package tpfinal.scrims.demo.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Estadistica {

    @Id
    private int id;
    @OneToOne
    private Scrim scrim;
    @OneToOne
    private Usuario usuario;
    private boolean mvp;
    private int kills;
    private int asistencias;
    private int muertes;
    private String observaciones;

    public double calcularKDA() {
        return (kills + asistencias) / Math.max(1.0, muertes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Scrim getScrim() {
        return scrim;
    }

    public void setScrim(Scrim scrim) {
        this.scrim = scrim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isMvp() {
        return mvp;
    }

    public void setMvp(boolean mvp) {
        this.mvp = mvp;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
