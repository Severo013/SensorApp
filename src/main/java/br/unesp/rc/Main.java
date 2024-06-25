package br.unesp.rc;

import java.io.IOException;
import static br.unesp.rc.utils.Tradutor.mapear;
import static br.unesp.rc.utils.Tradutor.traduzir;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        // Isso daqui faz com que saia caracteres especiais no output 
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8); // true = autoflush  
        

        //criar exemplo de cadastro de sensores

        //criar exemplo de processamento de anomalias

        //criar exemplo de chatbot
        //ChatGPTUtil chatGPTUtil = new ChatGPTUtil();
        //chatGPTUtil.gerarResposta("Olá, tudo bem?");

        //criar exemplo de gerar relatório
        
        /*Aqui tem um exemplo de como usar o texto e traduzir ele, precisaria transformar os textos
         que vão no pdf e atribui-los a variavel texto*/
        String texto = "Despite the popularity of electronic transactions, it’s clear that they won’t become the sole transaction method, at least in the near future. And as companies rush towards finding ever more convenient transaction methods, it’s important not to abandon those who prefer to pay in the traditional way.";
        //Descobre em que língua o texto estava escrito originalmente
        String linguagemTexto = mapear(texto);
        
        // Aqui ta traduzindo o texto da linguagem escrita originalmente e traduzindo ele pra português, dai é 
        // deixar parqa ao usuário escolher a língua que ele quer o texto final
        String resultadoTraduzido = traduzir(linguagemTexto, "pt", texto);
        out.println("Texto traduzido: " + resultadoTraduzido);
    }
}