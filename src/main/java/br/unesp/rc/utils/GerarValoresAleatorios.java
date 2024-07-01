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

    private static final Random random = new Random();

    // Gerar valor aleatório de pH entre 1 e 13.5
    //para agua potavel, o ideal é de 6.5 a 8.5
    public static double gerarPH() {
        return 1 + (13.5 - 1) * random.nextDouble();
    }

    // Gerar valor aleatório de Turbidez entre 0 e 5 NTU
    //o padrao de agua potavel é abaixo de 1 NTU
    public static double gerarTurbidez() {
        return 0 + (5 - 0) * random.nextDouble();
    }

    // Gerar valor aleatório de Condutividade entre 50 e 2250 µS/cm
    // a condutividade da agua potavel é entre 50 e 1500 µS/cm
    public static double gerarCondutividade() {
        return 50 + (2250 - 50) * random.nextDouble();
    }

    // Gerar valor aleatório de CO2 entre 100 e 2000 ppm
    //ares "normais" apresentam de 400 a 1000 ppm de CO2
    public static double gerarCO2() {
        return 100 + (1000 - 400) * random.nextDouble();
    }

    // Gerar valor aleatório de PM2.5 entre 0 e 50 µg/m³
    public static double gerarPM25() {
        return 0 + (50 - 0) * random.nextDouble();
    }

    // Gerar valor aleatório de O3 entre 0 e 100 ppb
    public static double gerarO3() {
        return 0 + (100 - 0) * random.nextDouble();
    }
}
