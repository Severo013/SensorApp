/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.modelo;

import java.util.List;

/**
 *
 * @author ottoj
 */
public interface IGeradorPDF {
    void gerarPDF(List<Sensor> listaSensor, String filePath);
}
