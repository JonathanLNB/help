package com.example.tarea1;

public class TipoFreno {
    private String freno;
    private int idFreno;
    public TipoFreno(int idFreno, String freno ) {
        this.idFreno=idFreno;
        this.freno = freno;
    }
    public int getIdFreno() {
        return idFreno;
    }
    public void setIdFreno(int idFreno) {
        this.idFreno = idFreno;
    }
    public String getFreno() {
        return freno;
    }
    @Override
    public String toString() {
        return freno;
    }
}