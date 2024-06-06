package br.unesp.rc.repositorio;

import br.unesp.rc.modelo.ISensor;

import java.util.ArrayList;
import java.util.List;

public class SensorRepositorio {
    private List<ISensor> sensores = new ArrayList<>();

    public void adicionarSensor(ISensor sensor) {
        sensores.add(sensor);
    }

    public void removerSensor(ISensor sensor) {
        sensores.remove(sensor);
    }

    public List<ISensor> obterSensores() {
        return sensores;
    }

    public ISensor obterSensorPorId(String id) {
        for (ISensor sensor : sensores) {
            if (sensor.obterId().equals(id)) {
                return sensor;
            }
        }
        return null;
    }

}
