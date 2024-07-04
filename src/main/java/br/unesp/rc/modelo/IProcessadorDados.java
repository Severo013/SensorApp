package br.unesp.rc.modelo;

import java.util.List;

public interface IProcessadorDados {
    String processarDados(List<Sensor> sensores, ETipo tipo);
}
