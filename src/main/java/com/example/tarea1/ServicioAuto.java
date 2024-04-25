package com.example.tarea1;

import java.util.Date;

public class ServicioAuto {
    private int idServAuto;
    private Servicio servicio;
    private Propiedad propiedad;
    private Date fechaServicio;

    public int getIdServAuto() {
        return idServAuto;
    }

    public void setIdServAuto(int idServAuto) {
        this.idServAuto = idServAuto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }
}
