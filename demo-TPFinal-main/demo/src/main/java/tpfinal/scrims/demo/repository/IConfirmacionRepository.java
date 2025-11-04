package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Confirmacion;
import tpfinal.scrims.demo.domain.model.Scrim;

public interface IConfirmacionRepository extends JpaRepository<Confirmacion, Integer> {

}
