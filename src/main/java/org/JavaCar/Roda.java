package org.JavaCar;

import java.io.Serializable;

public class Roda implements Serializable {

    private String marca;
    private double diametre;

    public Roda(String marca, double diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }

    public String getMarca() {
        return marca;
    }

    public double getDiametre() {
        return diametre;
    }

    @Override
    public String toString() {
        return "Roda{" +
                "marca='" + marca + '\'' +
                ", diametre=" + diametre +
                '}';
    }
}
