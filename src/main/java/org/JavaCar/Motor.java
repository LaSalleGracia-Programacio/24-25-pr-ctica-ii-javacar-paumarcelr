package org.JavaCar;

import java.io.Serializable;

public class Motor implements Serializable {
    private String tipus;
    private int potencia;

    public Motor(String tipus, int potencia) {
        this.tipus = tipus;
        this.potencia = potencia;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "tipus='" + tipus + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
