package br.unesp.rc.modelo;

import java.util.List;

public class ProcessadorMedia implements IProcessadorDados {

    @Override
    public void processarDados(List<ISensor> sensores) {
        double soma = 0;
        for (ISensor sensor : sensores) {
            soma += sensor.obterValor();
        }
        double media = soma / sensores.size();
        System.out.println("Média dos valores dos sensores: " + media);
    }
}
