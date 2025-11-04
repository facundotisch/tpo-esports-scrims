package tpfinal.scrims.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tpfinal.scrims.demo.domain.model.Notificacion;
import tpfinal.scrims.demo.domain.model.Postulacion;
import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Usuario;

import java.util.List;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario registrar(@RequestBody Usuario usuario) {
        return null;
    }

    @PutMapping("/{id}")
    public Usuario editarPerfil(@PathVariable int id, @RequestBody Usuario datos) {
        return null;
    }

    @PostMapping("/verificar")
    public Usuario verificarEmail(@RequestParam String token) {
        return null;
    }

    @GetMapping("/{id}/notificaciones")
    public List<Notificacion> obtenerNotificaciones(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/postulaciones")
    public List<Postulacion> obtenerPostulaciones(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{id}/scrims")
    public List<Scrim> obtenerScrimsDelUsuario(@PathVariable int id) {
        return null;
    }
}
