package tpfinal.scrims.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/scrim")
public class ScrimController {

    @PostMapping("/crear")
    public String crearScrim() {
     return null;
    }
    @PostMapping("/unirse")
    public String unirseAScrim() {
        return null;
    }
    @PostMapping("/{id}/postulaciones")
    public String postulacionesAScrim(@PathVariable int id) {
        return null;
    }
    @PutMapping("/{id}/postulaciones/{postId}/aceptar")
    public String aceptarScrim(@PathVariable int id, @PathVariable int postId) {
        return null;
    }

    @PutMapping("/{id}/postulaciones/{postId}/rechazar")
    public String rechazarScrim(@PathVariable int id, @PathVariable int postId) {
        return null;
    }
    @PostMapping("/{id}/estadisticas")
    public String registrarEstadisticasScrim(@PathVariable int id) {
        return null;
    }


    @PutMapping("/asignarRol")
    public String asignarRol() {
        return null;
    }
    @PutMapping("/confirmarJugador")
    public String confirmarJugador() {
        return null;
    }
    @DeleteMapping("/cerrar")
    public String cerrarScrim() {
        return null;
    }

}
