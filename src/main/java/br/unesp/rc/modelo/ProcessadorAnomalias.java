package br.unesp.rc.modelo;

import java.util.List;

public class ProcessadorAnomalias implements IProcessadorDados{

    //Classe para processamento de anomalias nos valores de sensor

    @Override
    public void processarDados(List<ISensor> sensores) {
        for (ISensor sensor : sensores) {
            if (sensor.obterTipo().equals("Sensor de Qualidade do Ar")) {
                if (sensor.obterValor() > 0.5) { // Valor de referência para detecção de anomalia
                    System.out.println("Anomalia detectada no sensor " + sensor.obterId());
                }
            }
        }
    }
}
