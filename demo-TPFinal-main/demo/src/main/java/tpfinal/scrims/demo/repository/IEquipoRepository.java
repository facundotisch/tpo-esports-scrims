package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Equipo;
import tpfinal.scrims.demo.domain.model.Scrim;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer> {

}
