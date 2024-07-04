package br.unesp.rc.repositorio;

import br.unesp.rc.modelo.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SensorRepositorio {
    private List<Sensor> sensores = new ArrayList<>();

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public void removerSensor(Sensor sensor) {
        sensores.remove(sensor);
    }

    public List<Sensor> obterSensores() {
        return sensores;
    }

    public Sensor obterSensorPorId(String id) {
        for (Sensor sensor : sensores) {
            if (sensor.obterId().equals(id)) {
                return sensor;
            }
        }
        return null;
    }

}
