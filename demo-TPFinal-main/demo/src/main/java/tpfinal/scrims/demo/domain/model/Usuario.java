package tpfinal.scrims.demo.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private int id;
    private String username;
    private String email;
    private String passwordHash;
    private String region;
    //private PreferenciasUsuario preferencias;
    //private EstadoVerificacion estadoEmail;

    public void registrar() {
        // TODO: registrar usuario en el sistema
    }

    public void editarPerfil(Usuario datos) {
        // TODO: actualizar datos del usuario
    }

    public void verificarEmail(String token) {
        // TODO: lógica para validar el token de confirmación
    }

    public void postularseScrim(Scrim scrim, String rol) {
        // TODO: asociar usuario a postulación de scrim
    }

    public void confirmarParticipacion(Scrim scrim, String rol) {
        // TODO: mover usuario a lista de confirmados
    }

    public void recibirNotification(Notificacion notification) {
        // TODO: consumir notificación según preferencias
    }

    // ------------------------
    // Getters & Setters
    // ------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

//    public PreferenciasUsuario getPreferencias() {
//        return preferencias;
//    }
//
//    public void setPreferencias(PreferenciasUsuario preferencias) {
//        this.preferencias = preferencias;
//    }
//
//    public EstadoVerificacion getEstadoEmail() {
//        return estadoEmail;
//    }
//
//    public void setEstadoEmail(EstadoVerificacion estadoEmail) {
//        this.estadoEmail = estadoEmail;
//    }
}
