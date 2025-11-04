package tpfinal.scrims.demo.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {

    @Id
    private int id;
    private String nombre;
    private String lado;
    @OneToMany
    private List<Usuario> jugadores = new ArrayList<>();

    public void agregarJugador(Usuario usuario) {
        jugadores.add(usuario);
    }

    public void removerJugador(Usuario usuario) {
        jugadores.remove(usuario);
    }

    public void intercambiarJugadores(Usuario usuario1, Usuario usuario2) {
        int i = jugadores.indexOf(usuario1);
        int j = jugadores.indexOf(usuario2);

        if (i != -1 && j != -1) {
            jugadores.set(i, usuario2);
            jugadores.set(j, usuario1);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }
}
