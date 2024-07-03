package br.unesp.rc.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorSensores implements IProcessadorDados {
    
    @Override
    public String processarDados(List<Sensor> sensores, ETipo tipo) {
        double somaValor1 = 0, somaValor2 = 0, somaValor3 = 0;
        int contador = 0;
        StringBuilder retorno = new StringBuilder();
        for (ISensor sensor : sensores) {
            if (sensor.obterTipo() == tipo) {
                contador+=1;
                
                ArrayList<Double> valores = sensor.obterValores();

                somaValor1 += valores.get(0);
                somaValor2 += valores.get(1);
                somaValor3 += valores.get(2);
            }
        }
        
        //caso haja aumento do escopo do projeto, será necessária a mudança
        //novos tipos de sensores = novos tipos de retornos

        if(contador>0){
            retorno.append("Média dos valores dos sensores:\n\t");
            retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "pH: " : "CO2: ");
            retorno.append(String.format("%.2f", somaValor1 / contador));
            if (tipo == ETipo.QUALIDADE_AR) {
                retorno.append(" ppm.");
            }
            retorno.append("\n\t").append(tipo == ETipo.QUALIDADE_AGUA ? "Turbidez: " : "PM2.5: ");
            retorno.append(String.format("%.2f", somaValor2 / contador));
            retorno.append((tipo == ETipo.QUALIDADE_AGUA ? " NTU." : " µg/m³."));
            retorno.append("\n\t").append(tipo == ETipo.QUALIDADE_AGUA ? "Condutividade: " : "O3: ");
            retorno.append(String.format("%.2f", somaValor3 / contador));
            retorno.append((tipo == ETipo.QUALIDADE_AGUA ? " µS/cm." : " ppb."));
            retorno.append('\n');
            return retorno.toString();
        }
        else
            return "Não existem sensores deste tipo cadastrados.\n";
    }
}
