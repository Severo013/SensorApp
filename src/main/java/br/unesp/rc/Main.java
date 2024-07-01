package br.unesp.rc;

import br.unesp.rc.modelo.ETipo;
import br.unesp.rc.modelo.ProcessadorAnomalias;
import static br.unesp.rc.utils.GerarValoresAleatorios.*;
import br.unesp.rc.modelo.ProcessadorSensores;
import br.unesp.rc.modelo.Sensor;
import br.unesp.rc.modelo.SensorQualidadeAgua;
import br.unesp.rc.modelo.SensorQualidadeAr;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //criar exemplo de cadastro de sensores
        List<Sensor> listaSensor = new ArrayList<>();
        //sensores de agua
        
        SensorQualidadeAgua sensor1 = new SensorQualidadeAgua("1", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor2 = new SensorQualidadeAgua("2", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor3 = new SensorQualidadeAgua("3", gerarPH(), gerarTurbidez(), gerarCondutividade());

        listaSensor.add(sensor1);
        listaSensor.add(sensor2);
        listaSensor.add(sensor3);
        
        //sensores de ar
        SensorQualidadeAr sensor4 = new SensorQualidadeAr("1", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor5 = new SensorQualidadeAr("2", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor6 = new SensorQualidadeAr("3", gerarCO2(), gerarPM25(), gerarO3());

        listaSensor.add(sensor4);
        listaSensor.add(sensor5);
        listaSensor.add(sensor6);

        ProcessadorSensores processador = new ProcessadorSensores();
        processador.processarDados(listaSensor, ETipo.QUALIDADE_AGUA);
        processador.processarDados(listaSensor, ETipo.QUALIDADE_AR);

        //criar exemplo de processamento de anomalias
        
        ProcessadorAnomalias procAnom= new ProcessadorAnomalias();
        procAnom.processarDados(listaSensor, ETipo.QUALIDADE_AGUA);
        procAnom.processarDados(listaSensor, ETipo.QUALIDADE_AR);
         
        //criar exemplo de chatbot
        //ChatGPTUtil chatGPTUtil = new ChatGPTUtil();
        //chatGPTUtil.gerarResposta("Olá, tudo bem?");
        //criar exemplo de gerar relatório
    }
}
