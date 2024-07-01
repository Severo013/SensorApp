package br.unesp.rc.modelo;

public abstract class Sensor implements ISensor {

    //Classe pai para os sensores do sistema, armazenando implementações comuns
    protected String id;
    protected ETipo tipo;

    public Sensor(String id, ETipo tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String obterId() {
        return id;
    }

    @Override
    public ETipo obterTipo() {
        return tipo;
    }
}
