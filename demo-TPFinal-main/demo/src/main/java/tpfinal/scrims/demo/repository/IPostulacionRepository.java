package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Equipo;
import tpfinal.scrims.demo.domain.model.Postulacion;
import tpfinal.scrims.demo.domain.model.Scrim;

public interface IPostulacionRepository extends JpaRepository<Postulacion, Integer> {

}
