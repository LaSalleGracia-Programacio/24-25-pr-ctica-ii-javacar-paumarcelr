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

    public int getPotencia() {
        return potencia;
    }


    @Override
    public String toString() {
        return "Motor{" +
                "tipus='" + tipus + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
