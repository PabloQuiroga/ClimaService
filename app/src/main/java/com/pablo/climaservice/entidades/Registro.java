package com.pablo.climaservice.entidades;

import java.io.Serializable;

/**
 * Created by Pablo Daniel Quiroga on 17/3/2018.
 * Entidad para el registro en DDBB
 */

public class Registro implements Serializable {
    private String fecha;
    private String clima;

    public Registro(){}
    public Registro(String f, String c){
        this.fecha = f;
        this.clima = c;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "fecha = " + fecha +
                ", clima = " + clima +
                " )";
    }
}
