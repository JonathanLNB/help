package com.example.tarea1;

public class Automovil {
    private int idAuto;
    private Marca marca;
    private String modelo;
    private String color;
    private double peso;
    private Transmision tipoTrans;
    private String numPuertas;
    private String numPersonas;
    private String motor;
    private TipoFreno tipoFreno;
    private String velocidades;
    private Accesorio accesorios;
    private String foto;

    public Automovil(int idAuto, Marca marca, String modelo, String color, double peso, Transmision tipoTrans, String numPuertas, String numPersonas, String motor, TipoFreno tipoFreno, String velocidades, Accesorio accesorios, String foto) {
        this.idAuto = idAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.peso = peso;
        this.tipoTrans = tipoTrans;
        this.numPuertas = numPuertas;
        this.numPersonas = numPersonas;
        this.motor = motor;
        this.tipoFreno = tipoFreno;
        this.velocidades = velocidades;
        this.accesorios = accesorios;
        this.foto = foto;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Transmision getTransmision() {
        return tipoTrans;
    }

    public void setTipoTrans(Transmision transmision) {
        this.tipoTrans = transmision;
    }

    public String getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(String numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(String numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public TipoFreno getTipoFrenos() {
        return tipoFreno;
    }

    public void setTipoFrenos(TipoFreno tipoFreno) {
        this.tipoFreno = tipoFreno;
    }

    public String getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(String velocidades) {
        this.velocidades = velocidades;
    }

    public Accesorio getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Accesorio accesorio) {
        this.accesorios = accesorio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Transmision getTipoTrans() {
        return tipoTrans;
    }

    public TipoFreno getTipoFreno() {
        return tipoFreno;
    }

    public void setTipoFreno(TipoFreno tipoFreno) {
        this.tipoFreno = tipoFreno;
    }
}
