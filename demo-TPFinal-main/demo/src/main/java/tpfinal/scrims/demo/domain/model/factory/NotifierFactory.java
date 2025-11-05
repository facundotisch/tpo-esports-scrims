package tpfinal.scrims.demo.domain.model.factory;

import tpfinal.scrims.demo.domain.model.Observer;

public interface NotifierFactory {
    Observer crearEmail();
    Observer crearPush();
}
