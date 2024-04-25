package com.example.tarea1;

public class Accesorio {
    private String accesorio;
    private int id;

    public Accesorio(int id, String accesorio) {
        this.id = id;
        this.accesorio = accesorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return accesorio;
    }

    @Override
    public String toString() {
        return accesorio;
    }
}

