package br.unesp.rc.modelo;

import java.util.ArrayList;

public interface ISensor {
    String obterId();
    ETipo obterTipo();
    ArrayList<Double> obterValores();
}
