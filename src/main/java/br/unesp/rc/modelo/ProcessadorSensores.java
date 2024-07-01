package br.unesp.rc.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorSensores implements IProcessadorDados {

    public void processarDados(List<Sensor> sensores, ETipo tipo) {
        double somaValor1 = 0, somaValor2 = 0, somaValor3 = 0;
        int contador = 0;
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        for (ISensor sensor : sensores) {
            if (sensor.obterTipo() == tipo) {
                contador++;

                System.out.println("Sensor " + sensor.obterId() + ':' + sensor.toString());

                ArrayList<Double> valores = sensor.obterValores();

                somaValor1 += valores.get(0);
                somaValor2 += valores.get(1);
                somaValor3 += valores.get(2);
            }
        }
        
        //caso haja aumento do escopo do projeto, será necessária a mudança
        //novos tipos de sensores = novos tipos de retornos
        
        StringBuilder retorno = new StringBuilder();
        retorno.append("Média dos valores dos sensores:\n\t");
        retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "pH: " : "CO2: ");
        retorno.append(String.format("%.2f", somaValor1 / contador));
        if (tipo == ETipo.QUALIDADE_AR) {
            retorno.append(" ppm.");
        }
        retorno.append("\n\t" + (tipo == ETipo.QUALIDADE_AGUA ? "Turbidez: " : "PM2.5: "));
        retorno.append(String.format("%.2f", somaValor2 / contador));
        retorno.append((tipo == ETipo.QUALIDADE_AGUA ? " NTU." : " µg/m³."));
        retorno.append("\n\t" + (tipo == ETipo.QUALIDADE_AGUA ? "Condutividade: " : "O3: "));
        retorno.append(String.format("%.2f", somaValor3 / contador));
        retorno.append((tipo == ETipo.QUALIDADE_AGUA ? " µS/cm." : " ppb."));
        System.out.println(retorno + "\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        /*
        if(tipo==ETipo.QUALIDADE_AGUA)
            System.out.printf("Média dos valores dos sensores:\n\tpH: %.2f\n\tTurbidez: %.2f NTU\n\tCondutividade: %.2f µS/cm\n",
                somaValor1/contador, somaValor2/contador, somaValor3/contador);
        else if(tipo==ETipo.QUALIDADE_AR)
            System.out.printf("Média dos valores dos sensores:\n\tCO2: %.2f ppm\n\tPM2.5: %.2f µg/m³\n\tO3: %.2f ppb\n",
                somaValor1/contador, somaValor2/contador, somaValor3/contador);*/
    }
}
