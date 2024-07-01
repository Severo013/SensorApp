package br.unesp.rc.modelo;

import java.util.ArrayList;

public class SensorQualidadeAr extends Sensor {

    private double indicadorCO2;
    private double indicadorPM;
    private double indicadorO3;

    public SensorQualidadeAr(String id, double co2, double pm, double o3) {
        super(id, ETipo.QUALIDADE_AR);
        this.indicadorCO2 = co2;
        this.indicadorPM = pm;
        this.indicadorO3 = o3;
    }

    public double getIndicadorCO2() {
        return indicadorCO2;
    }

    public void setIndicadorCO2(double indicadorCO2) {
        this.indicadorCO2 = indicadorCO2;
    }

    public double getIndicadorPM() {
        return indicadorPM;
    }

    public void setIndicadorPM(double indicadorPM) {
        this.indicadorPM = indicadorPM;
    }

    public double getIndicadorO3() {
        return indicadorO3;
    }

    public void setIndicadorO3(double indicadorO3) {
        this.indicadorO3 = indicadorO3;
    }

    @Override
    public String toString() {
        return "\n\tCO2: " + String.format("%.2f", indicadorCO2) 
                + " ppm\n\tPM2.5: " + String.format("%.2f",indicadorPM) 
                + " µg/m³\n\tO3: " + String.format("%.2f",indicadorO3) + " ppb\n";
    }

    @Override
    public ArrayList<Double> obterValores() {
        //segue ordem CO2, PM2.5, O3
        ArrayList<Double> valores = new ArrayList<>();
        valores.add(indicadorCO2);
        valores.add(indicadorPM);
        valores.add(indicadorO3);
        return valores;
    }
}
