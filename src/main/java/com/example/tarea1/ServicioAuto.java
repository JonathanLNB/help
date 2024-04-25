package com.example.tarea1;

import java.util.Date;

public class ServicioAuto {
    private int idServicioAuto;
    private Servicio servicio;
    private Propiedad propiedad;
    private Date fechaServicio;

    public ServicioAuto(int idServicioAuto, Servicio servicio, Propiedad propiedad, Date fechaServicio) {
        this.idServicioAuto = idServicioAuto;
        this.servicio = servicio;
        this.propiedad = propiedad;
        this.fechaServicio = fechaServicio;
    }

    public int getIdServicioAuto() {
        return idServicioAuto;
    }

    public void setIdServicioAuto(int idServicioAuto) {
        this.idServicioAuto = idServicioAuto;
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
