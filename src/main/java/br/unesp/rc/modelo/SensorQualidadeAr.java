package br.unesp.rc.modelo;

public class SensorQualidadeAr implements ISensor {

    private String id;
    private String tipo;
    private double valor;

    public SensorQualidadeAr(String id) {
        this.id = id;
    }

    @Override
    public String obterId() {
        return id;
    }

    @Override
    public String obterTipo() {
        return "Sensor de Qualidade do Ar";
    }

    @Override
    public double obterValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
