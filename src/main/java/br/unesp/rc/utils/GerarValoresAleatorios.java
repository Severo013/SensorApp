/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.utils;

import java.util.Random;

/**
 *
 * @author ottoj
 */
public class GerarValoresAleatorios {

    /*gera um valor (provavelmente) anormal e o soma com um valor padrão,
     entao retorna a media, para um valor nao tao extremo*/
    private static final Random random = new Random();

    // Gerar valor aleatório de pH entre 1 e 13.5
    //para agua potavel, o ideal é de 6.5 a 8.5
    public static double gerarPH() {
        return (1 + (13.5 - 1) * random.nextDouble() + 6.5 + (8.5 - 6.5) * random.nextDouble()) / 2;
    }

    // Gerar valor aleatório de Turbidez entre 0 e 5 NTU
    //o padrao de agua potavel é abaixo de 1 NTU
    public static double gerarTurbidez() {
        return ((5 - 0) * random.nextDouble() + (0.5) * random.nextDouble()) / 2;
    }

    // Gerar valor aleatório de Condutividade entre 50 e 2250 µS/cm
    // a condutividade da agua potavel é entre 50 e 1055 µS/cm
    public static double gerarCondutividade() {
        return (10 + (3000 - 10) * random.nextDouble() + 50 + (1500 - 50) * random.nextDouble()) / 2;
    }

    // Gerar valor aleatório de CO2 entre 100 e 2000 ppm
    //ares "normais" apresentam de 400 a 1000 ppm de CO2
    public static double gerarCO2() {
        return (100 + (2000 - 100) * random.nextDouble() + 400 + (1000 - 400) * random.nextDouble()) / 2;
    }

    // Gerar valor aleatório de PM2.5 entre 0 e 50 µg/m³
    //A qualidade do ar geralmente é considerada boa se o valor de PM2.5 está abaixo de 12 µg/m³
    public static double gerarPM25() {
        return ((45 - 0) * random.nextDouble() + (12 - 0) * random.nextDouble()) / 2;
    }

    // Gerar valor aleatório de O3 entre 0 e 100 ppb
    //acima de 70ppb sao prejudiciais à saúde
    public static double gerarO3() {
        return ((100 - 0) * random.nextDouble() + (70 - 0) * random.nextDouble()) / 2;
    }
}
