package br.unesp.rc;

import br.unesp.rc.modelo.ETipo;
import static br.unesp.rc.utils.GerarValoresAleatorios.*;
import br.unesp.rc.modelo.ProcessadorSensores;
import br.unesp.rc.modelo.Sensor;
import br.unesp.rc.modelo.SensorQualidadeAgua;
import br.unesp.rc.modelo.SensorQualidadeAr;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        System.out.println("Olá mundo!");

        //criar exemplo de cadastro de sensores
        //sensores de agua
        SensorQualidadeAgua sensor1 = new SensorQualidadeAgua("1", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor2 = new SensorQualidadeAgua("2", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor3 = new SensorQualidadeAgua("3", gerarPH(), gerarTurbidez(), gerarCondutividade());
        
        List<Sensor> listaAgua = new ArrayList<>();
        ProcessadorSensores processador= new ProcessadorSensores();
        
        listaAgua.add(sensor1);
        listaAgua.add(sensor2);
        listaAgua.add(sensor3);
        
        processador.processarDadosAgua(listaAgua);
        
        
        //sensores de ar
        /*
        SensorQualidadeAr sensor4 = new SensorQualidadeAr("1", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor5 = new SensorQualidadeAr("2", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor6 = new SensorQualidadeAr("3", gerarCO2(), gerarPM25(), gerarO3());
        
        List<Sensor> listaAr = new ArrayList<>();
        
        listaAr.add(sensor4);
        listaAr.add(sensor5);
        listaAr.add(sensor6);
        
        processador.processarDadosAr(listaAr);
        */

        //criar exemplo de processamento de anomalias

        //criar exemplo de chatbot
        //ChatGPTUtil chatGPTUtil = new ChatGPTUtil();
        //chatGPTUtil.gerarResposta("Olá, tudo bem?");

        //criar exemplo de gerar relatório

    }
}