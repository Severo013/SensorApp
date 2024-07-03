package br.unesp.rc.modelo;

import java.util.List;

public interface IProcessadorDados {
    abstract String processarDados(List<Sensor> sensores, ETipo tipo);
}
