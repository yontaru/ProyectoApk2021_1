package com.example.proyectoapk2021_1;

import java.io.Serializable;

public class Actividad implements Serializable {
    String nombreActividad, descripcionActividad;
    int fotoActividad;

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public int getFotoActividad() {
        return fotoActividad;
    }

    public void setFotoActividad(int fotoActividad) {
        this.fotoActividad = fotoActividad;
    }

    public Actividad(String nombreActividad, String descripcionActividad, int fotoActividad) {
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.fotoActividad = fotoActividad;
    }
}
