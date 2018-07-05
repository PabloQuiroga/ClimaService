package com.pablo.climaservice.entidades;

public class Ubicacion {

    private double latitud;
    private double longitud;
    private String zona;

    public Ubicacion(double latitud, double longitud, String zona) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.zona = zona;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
}
