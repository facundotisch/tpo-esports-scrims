package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Scrim;
import tpfinal.scrims.demo.domain.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
