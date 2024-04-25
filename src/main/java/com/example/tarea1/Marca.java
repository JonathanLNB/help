package com.example.tarea1;
public class Marca {
    private String nombre;
    private int id;
    public Marca(int id, String nombre ) {
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
