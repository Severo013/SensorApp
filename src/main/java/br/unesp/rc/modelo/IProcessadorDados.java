package br.unesp.rc.modelo;

import java.util.List;

public interface IProcessadorDados {
    abstract void processarDados(List<ISensor> sensores);
}
