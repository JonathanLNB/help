package com.example.tarea1;

public class Accesorio {
    private String nombre;
    private int id;
    public Accesorio(int id, String nombre ) {
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

