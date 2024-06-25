/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unesp.rc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MapeadorDeLinguagem {

    /* 
        Esse arquivo contém as funções da OpenNPL, para a o mapeamento da linguagem 
     */
    public String getLanguage(String langCode) throws IOException {

        HashMap<String, String> langMap = readToHashmap();

        return langMap.get(langCode);

    }

    // Pega o nome das linguagens disponiveis no modelo
    public HashMap<String, String> readToHashmap() throws IOException {
        HashMap<String, String> map = new HashMap<String, String>();
        BufferedReader in = new BufferedReader(new FileReader(".\\resources\\language_mapping.txt"));
        String line = "";

        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");
            map.put(parts[0], parts[1]);
        }
        in.close();

        return map;

    }
}
