/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.rc.utils;

import java.io.BufferedReader;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageDetector;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 *
 * @author Julia
 */
public class Tradutor {

    /* 
        Esse arquivo contém as funções da OpenNPL, que mapeia e traduz os textos
     */
    
    // Indica a língua do texto
    public static String mapear(String texto) throws IOException {
        MapeadorDeLinguagem languageMapper = new MapeadorDeLinguagem();
        // Carregando o arquivo do modelo de detecção de linguagem
        File modelFile = new File(".\\resources\\langdetect-183.bin");
        LanguageDetectorModel trainedModel = new LanguageDetectorModel(modelFile);

        // Carregando o modelo
        LanguageDetector languageDetector = new LanguageDetectorME(trainedModel);

        // Frase a ser descoberta a língua
        Language[] languages = languageDetector.predictLanguages(texto);
        
        String lingua = languages[0].getLang().substring(0, 2);
        //System.out.println("Língua do texto: " + lingua);
        return lingua;
    }
    
    // Traduz o texto para a língua indicada, usando de apoio a API de NPL do Google 
    public static String traduzir(String langFrom, String langTo, String text) throws IOException {
        String urlStr = "https://script.google.com/macros/s/AKfycbwM8bTjlb85nyApZ6sowaK46nOVfhUJMBpwMvn5csw8f3tuAzFbzuiO87k1z1P4mloO/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
