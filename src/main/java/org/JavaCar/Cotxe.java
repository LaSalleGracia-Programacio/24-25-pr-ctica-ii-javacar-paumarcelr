package org.JavaCar;

public class Cotxe extends Vehicle{
    private int nombrePlaces;
    public Cotxe(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, int nombrePlaces) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }
}
