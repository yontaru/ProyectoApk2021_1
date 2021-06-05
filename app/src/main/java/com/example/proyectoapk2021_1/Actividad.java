package com.example.proyectoapk2021_1;

import java.io.Serializable;

public class Actividad implements Serializable {
    String nombreActividad, descripcionActividad, fotoActividad;

    public Actividad(String nombreActividad, String descripcionActividad, String fotoActividad) {
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.fotoActividad = fotoActividad;
    }

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

    public String getFotoActividad() {
        return fotoActividad;
    }

    public void setFotoActividad(String fotoActividad) {
        this.fotoActividad = fotoActividad;
    }
}
