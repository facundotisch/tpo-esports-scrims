package tpfinal.scrims.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tpfinal.scrims.demo.domain.model.enums.Formatos;
import tpfinal.scrims.demo.domain.model.enums.Juegos;
import tpfinal.scrims.demo.domain.state.ScrimState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Scrim {

    @Id
    private int id;
    private Juegos juego;
    private ScrimState estado;
    private Formatos formato;
    private double rangoMin;
    private double rangoMax;
    private String region;
    private LocalDate fecha;
    private double latenciaMax;
    @OneToMany
    private List<Usuario> confirmados = new ArrayList<>();


    public void notificarCambioEstado() {
        // TODO: implementar observer/notification
    }

    public void postularJugador(Usuario u, String rol) {
        // TODO: lógica para registrar postulación
    }

    public void confirmarJugador(Usuario u) {
        // TODO: lógica de confirmación y mover a "confirmados"
    }

    public void iniciarScrim() {
    }

    public void finalizarScrim() {

    }

    public void setEstado(Scrim scrim, ScrimState nuevoEstado) {
        this.estado = nuevoEstado;
        notificarCambioEstado();
    }

    public void cancelarScrim() {

    }

}


