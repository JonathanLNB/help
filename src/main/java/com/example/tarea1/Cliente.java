package com.example.tarea1;

public class Cliente {
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private int idCliente;

    public Cliente(int idCliente, String nombres, String aPaterno, String aMaterno) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    @Override
    public String toString() {
        return nombres;
    }
}
