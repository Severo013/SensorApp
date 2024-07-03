/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.modelo;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ottoj
 */
public class Relatorio {
    private final GeradorPDF geradorPDF;

    public Relatorio() throws IOException {
        this.geradorPDF = new GeradorPDF();
    }

    public void criarRelatorio(List<Sensor> listaSensor) {
        geradorPDF.gerarPDF(listaSensor);
    }
}
