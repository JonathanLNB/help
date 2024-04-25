package com.example.tarea1;

public class Cliente {
    private String nombres;
    private String APaterno;
    private String AMaterno;
    private int id;
    public Cliente(int id, String nombres , String APaterno, String AMaterno) {
        this.id=id;
        this.nombres = nombres;
        this.APaterno=APaterno;
        this.AMaterno=AMaterno;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }

    public String getAPaterno() {
        return APaterno;
    }

    public void setAPaterno(String APaterno) {
        this.APaterno = APaterno;
    }

    public String getAMaterno() {
        return AMaterno;
    }

    public void setAMaterno(String AMaterno) {
        this.AMaterno = AMaterno;
    }

    @Override
    public String toString() {
        return nombres;
    }
}
