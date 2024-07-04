package br.unesp.rc.modelo;

import java.util.ArrayList;

public class SensorQualidadeAgua extends Sensor {

    private double indicadorPH;
    private double indicadorTurbidez;
    private double indicadorCondutividade;

    public SensorQualidadeAgua(String id, double ph, double turb, double cond) {
        super(id, ETipo.QUALIDADE_AGUA);
        this.indicadorPH = ph;
        this.indicadorCondutividade = cond;
        this.indicadorTurbidez = turb;
    }

    @Override
    public String toString() {
        return  "Sensor - id: " + id +
                "\n\tPH: " + String.format("%.2f",indicadorPH)
                + "\n\tTurbidez: " + String.format("%.2f",indicadorTurbidez)
                + " NTU\n\tCondutividade: " + String.format("%.2f",indicadorCondutividade) + " µS/cm\n";
    }

    @Override
    public ArrayList<Double> obterValores() {
        //segue ordem ph, turbidez, condutividade
        ArrayList<Double> valores = new ArrayList<>();
        valores.add(indicadorPH);
        valores.add(indicadorTurbidez);
        valores.add(indicadorCondutividade);
        return valores;
    }
}
