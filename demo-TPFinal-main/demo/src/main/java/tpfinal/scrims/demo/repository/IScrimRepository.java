package tpfinal.scrims.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpfinal.scrims.demo.domain.model.Scrim;

public interface IScrimRepository extends JpaRepository<Scrim, Integer> {

}
