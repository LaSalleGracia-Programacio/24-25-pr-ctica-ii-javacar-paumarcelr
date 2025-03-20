package org.JavaCar;

import java.util.Arrays;
public class Cotxe extends Vehicle{
    private int nombrePlaces;
    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    @Override
    public String toString() {
        String cotxeInfo = "Marca: " + marca + "\n" +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + "\n" +
                "Preu/dia: " + preuBase + "\n" +
                "Tipus de motor: " + motor.getTipus() + "\n" +
                "Marca de roda: " + rodes[0].getMarca() + "\n" +
                "Any de matriculació: " + anyMatriculacio + "\n";

        if (enchufable)
        {
            cotxeInfo += "És enchufable \n";
        }

        if (autonomiaElectirc != 0)
        {
            cotxeInfo += "Velocitat en autonomia electrica: " + autonomiaElectirc  +"\n";
        }

        cotxeInfo += "Eriqueta ambiental: " + etiqueta.toString();
        return  cotxeInfo;
    }
}
