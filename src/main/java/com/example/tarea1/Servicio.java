package com.example.tarea1;

public class Servicio {
    private String nombre;
    private int id;
    public Servicio(int id, String nombre ) {
        this.id=id;
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }
}
