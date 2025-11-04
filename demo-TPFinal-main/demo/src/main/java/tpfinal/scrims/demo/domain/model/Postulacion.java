package tpfinal.scrims.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tpfinal.scrims.demo.domain.model.enums.EstadoPostulacion;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postulacion {

    @Id
    private int id;
    @OneToOne
    private Usuario usuario;
    @ManyToOne
    private Scrim scrim;
    private String rolDeseado;
    private EstadoPostulacion estado;


    public void aceptar() {
        this.estado = EstadoPostulacion.ACEPTADA;
    }

    public void rechazar() {
        this.estado = EstadoPostulacion.RECHAZADA;
    }

    public void cancelar() {
        this.estado = EstadoPostulacion.CANCELADA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Scrim getScrim() {
        return scrim;
    }

    public void setScrim(Scrim scrim) {
        this.scrim = scrim;
    }

    public String getRolDeseado() {
        return rolDeseado;
    }

    public void setRolDeseado(String rolDeseado) {
        this.rolDeseado = rolDeseado;
    }

    public EstadoPostulacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoPostulacion estado) {
        this.estado = estado;
    }
}