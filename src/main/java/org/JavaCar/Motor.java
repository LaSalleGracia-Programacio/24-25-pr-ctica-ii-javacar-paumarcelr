package org.JavaCar;

public class Motor {

    String tipus;
    int potencia;

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
}
