/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.modelo;

/**
 *
 * @author ottoj
 */
public enum EParametroAnomalia {
    PH(6.5,8.5), 
    TURBIDEZ(1,0), 
    CONDUTIVIDADE(50,1055), 
    CO2(400,1000), 
    PM2_5(12,35), 
    O3(0,70);
    
    //campos de instância
    private final double min;
    private final double max;
    
    //construtor
    EParametroAnomalia(double min, double max){
        this.min=min;
        this.max=max;
    }
    
    public double getMin(){
        return min;
    }
    
    public double getMax(){
        return max;
    }
}
