package com.pablo.climaservice.entidades;

public class Clima {

    private String estadoActual;
    private int temperatura;
    private String actualizacion;

    public Clima(String estadoActual, int temperatura, String actualizacion) {
        this.estadoActual = estadoActual;
        this.temperatura = temperatura;
        this.actualizacion = actualizacion;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(String actualizacion) {
        this.actualizacion = actualizacion;
    }
}
