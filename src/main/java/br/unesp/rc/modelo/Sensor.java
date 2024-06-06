package br.unesp.rc.modelo;

public abstract class Sensor implements ISensor {

    protected String id;
    protected double valor;
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
    public double obterValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String obterTipo() {
        return switch (tipo) {
            case QUALIDADE_AGUA -> "Sensor de Qualidade da Água";
            case QUALIDADE_AR -> "Sensor de Qualidade do Ar";
            default -> "Tipo de sensor desconhecido";
        };
    }
}