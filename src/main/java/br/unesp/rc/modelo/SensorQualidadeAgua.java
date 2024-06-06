package br.unesp.rc.modelo;

public class SensorQualidadeAgua implements ISensor {

    private String id;
    private String tipo;
    private double valor;

    public SensorQualidadeAgua(String id) {
        this.id = id;
    }

    @Override
    public String obterId() {
        return id;
    }

    @Override
    public String obterTipo() {
        return "Sensor de Qualidade da Água";
    }

    @Override
    public double obterValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
