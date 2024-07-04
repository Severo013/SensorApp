package br.unesp.rc;

import static br.unesp.rc.utils.GerarValoresAleatorios.*;
import static br.unesp.rc.utils.Tradutor.mapear;
import static br.unesp.rc.utils.Tradutor.traduzir;

import br.unesp.rc.modelo.Relatorio;
import br.unesp.rc.modelo.SensorQualidadeAgua;
import br.unesp.rc.modelo.SensorQualidadeAr;
import br.unesp.rc.repositorio.SensorRepositorio;
import br.unesp.rc.utils.ChatGPTUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //Exemplo de cadastro de sensores
        SensorRepositorio sensorRepositorio = new SensorRepositorio();

        //Sensores de água
        SensorQualidadeAgua sensor1 = new SensorQualidadeAgua("1", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor2 = new SensorQualidadeAgua("2", gerarPH(), gerarTurbidez(), gerarCondutividade());
        SensorQualidadeAgua sensor3 = new SensorQualidadeAgua("3", gerarPH(), gerarTurbidez(), gerarCondutividade());

        sensorRepositorio.adicionarSensor(sensor1);
        sensorRepositorio.adicionarSensor(sensor2);
        sensorRepositorio.adicionarSensor(sensor3);
        
        //Sensores de ar
        SensorQualidadeAr sensor4 = new SensorQualidadeAr("1", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor5 = new SensorQualidadeAr("2", gerarCO2(), gerarPM25(), gerarO3());
        SensorQualidadeAr sensor6 = new SensorQualidadeAr("3", gerarCO2(), gerarPM25(), gerarO3());

        sensorRepositorio.adicionarSensor(sensor4);
        sensorRepositorio.adicionarSensor(sensor5);
        sensorRepositorio.adicionarSensor(sensor6);

        System.out.println("Gerando relatório...\n");
        Relatorio relatorio = new Relatorio();
        relatorio.criarRelatorio(sensorRepositorio.obterSensores());
        System.out.println("Relatório gerado com sucesso!\n");

        //Exemplo ChatBot
        String input = "Hi, what is the importance of taking care of the environment?";
        System.out.println("Pergunta: " + input + "\n");
        ChatGPTUtil chatGPTUtil = new ChatGPTUtil();
        String resposta = chatGPTUtil.gerarResposta(input);
        System.out.println("Resposta: " + resposta + "\n");

        //Traduzindo resposta ChatBot
        System.out.println("Traduzindo texto...\n");

        //Descobre em que língua o texto estava escrito originalmente
        String linguagemTexto = mapear(resposta);

        String resultadoTraduzido = traduzir(linguagemTexto, "pt", resposta);
        System.out.println("\nTexto traduzido: " + resultadoTraduzido);
    }
}
