package com.example.tarea1;

public class Transmision {
    private String transmision;
    private int idTransmision;

    public Transmision(int idTransmision, String transmision) {
        this.idTransmision = idTransmision;
        this.transmision = transmision;
    }

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getTransmision() {
        return transmision;
    }

    @Override
    public String toString() {
        return transmision;
    }
}
