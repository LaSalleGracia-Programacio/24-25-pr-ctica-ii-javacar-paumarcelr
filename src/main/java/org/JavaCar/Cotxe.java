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
        String cotxeInfo = "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Any de matriculació: " + anyMatriculacio + "\n" +
                "Preu/dia: " + preuBase + " | " +
                "Numero de places: " + nombrePlaces + "\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n";

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
