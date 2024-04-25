package com.example.tarea1;

public class Servicio {
    private String servicio;
    private int idServicio;

    public Servicio(int id, String servicio) {
        this.idServicio = idServicio;
        this.servicio = servicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getServicio() {
        return servicio;
    }

    @Override
    public String toString() {
        return servicio;
    }
}
