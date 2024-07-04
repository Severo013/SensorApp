package br.unesp.rc.modelo;

import java.util.List;

public class ProcessadorMedia implements IProcessadorDados {

    @Override
    public String processarDados(List<Sensor> sensores, ETipo tipo) {
        double somaValor1 = 0, somaValor2 = 0, somaValor3 = 0;
        int contador = 0;
        for (Sensor sensor : sensores) {
            if (sensor.obterTipo() == tipo) {
                contador++;
                List<Double> valores = sensor.obterValores();
                somaValor1 += valores.get(0);
                somaValor2 += valores.get(1);
                somaValor3 += valores.get(2);
            }
        }

        if (contador == 0) {
            return "Não existem sensores deste tipo cadastrados.\n";
        }

        String tipoMedida1 = tipo == ETipo.QUALIDADE_AGUA ? "pH: " : "CO2: ";
        String tipoMedida2 = tipo == ETipo.QUALIDADE_AGUA ? "Turbidez: " : "PM2.5: ";
        String tipoMedida3 = tipo == ETipo.QUALIDADE_AGUA ? "Condutividade: " : "O3: ";
        String unidade1 = tipo == ETipo.QUALIDADE_AGUA ? "" : " ppm.";
        String unidade2 = tipo == ETipo.QUALIDADE_AGUA ? " NTU." : " µg/m³.";
        String unidade3 = tipo == ETipo.QUALIDADE_AGUA ? " µS/cm." : " ppb.";

        return String.format("Média dos valores dos sensores:\n\t%s%.2f%s\n\t%s%.2f%s\n\t%s%.2f%s\n",
                tipoMedida1, somaValor1 / contador, unidade1,
                tipoMedida2, somaValor2 / contador, unidade2,
                tipoMedida3, somaValor3 / contador, unidade3);
    }
}

