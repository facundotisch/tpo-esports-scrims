package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Notificacion;
import tpfinal.scrims.demo.domain.model.Scrim;

public interface INotificacionRepository extends JpaRepository<Notificacion, Integer> {

}
