package com.example.tarea1;

public class TipoFreno {
    private String tipoFreno;
    private int idTipoFreno;

    public TipoFreno(int idTipoFreno, String tipoFreno) {
        this.idTipoFreno = idTipoFreno;
        this.tipoFreno = tipoFreno;
    }

    public int getIdTipoFreno() {
        return idTipoFreno;
    }

    public void setIdTipoFreno(int idTipoFreno) {
        this.idTipoFreno = idTipoFreno;
    }

    public String getTipoFreno() {
        return tipoFreno;
    }

    @Override
    public String toString() {
        return tipoFreno;
    }
}