package org.JavaCar;

import java.util.Arrays;

public class Furgoneta extends Vehicle{
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
        if (capacitatCarga >1000)
        {
            this.preuBase += 10;
        }
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        return super.calcularPreu(dies);
    }

    @Override
    public String toString() {
        String furgonetaInfo = "Marca: " + marca + " | " +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + " | " +
                "Any de matriculació: " + anyMatriculacio + "\n" +
                "Preu/dia: " + preuBase + " | " +
                "Capacitat de carga: " + capacitatCarga + "\n" +
                "Tipus de motor: " + motor.getTipus() + " | " +
                "Marca de roda: " + rodes[0].getMarca() + "\n";

        if (enchufable)
        {
            furgonetaInfo += "És enchufable \n";
        }

        if (autonomiaElectirc != 0)
        {
            furgonetaInfo += "Velocitat en autonomia electrica: " + autonomiaElectirc  +"\n";
        }

        furgonetaInfo += "Eriqueta ambiental: " + etiqueta.toString();
        return  furgonetaInfo;
    }
}
