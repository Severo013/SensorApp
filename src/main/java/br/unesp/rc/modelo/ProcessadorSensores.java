package br.unesp.rc.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorSensores implements IProcessadorDados {

    public void processarDadosAgua(List<Sensor> sensores){
        double somaPH=0, somaTurb=0, somaCond=0;
        int contador=0;
        for (ISensor sensor : sensores) {
            if(sensor.obterTipo()==ETipo.QUALIDADE_AGUA){
                contador++;
                
                System.out.println("Sensor "+ sensor.obterId() + ':'+sensor.toString());
                
                ArrayList<Double> valores=sensor.obterValores();
                
                somaPH+=valores.get(0);
                somaTurb+=valores.get(1);
                somaCond+=valores.get(2);
            }
        }
        System.out.printf("Média dos valores dos sensores:\n\tPH: %.2f\n\tTurbidez: %.2f NTU\n\tCondutividade: %.2f µS/cm\n",
                somaPH/contador, somaTurb/contador, somaCond/contador);
    }
    
    public void processarDadosAr(List<Sensor> sensores){
        double somaCO2=0, somaPM=0, somaO3=0;
        int contador=0;
        for (ISensor sensor : sensores) {
            if(sensor.obterTipo()==ETipo.QUALIDADE_AR){
                contador++;
                
                System.out.println("Sensor "+ sensor.obterId() + ':'+sensor.toString());
                
                ArrayList<Double> valores=sensor.obterValores();
                
                somaCO2+=valores.get(0);
                somaPM+=valores.get(1);
                somaO3+=valores.get(2);
            }
        }
        System.out.printf("Média dos valores dos sensores:\n\tCO2: %.2f\n\tPM2.5: %.2f µg/m³\n\tO3: %.2f ppb\n",
                somaCO2/contador, somaPM/contador, somaO3/contador);
    }

    @Override
    public void processarDados(List<ISensor> sensores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
