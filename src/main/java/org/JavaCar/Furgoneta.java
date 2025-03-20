package org.JavaCar;

import java.util.Arrays;

public class Furgoneta extends Vehicle{
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga >1000)
        {
            return (preuBase + 10) * dies;
        } else {
            return super.calcularPreu(dies);
        }
    }

    @Override
    public String toString() {
        String furgonetaInfo = "Marca: " + marca + "\n" +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + "\n" +
                "Preu/dia: " + preuBase + "\n" +
                "Capacitat de carga: " + capacitatCarga + "\n" +
                "Tipus de motor: " + motor.getTipus() + "\n" +
                "Marca de roda: " + rodes[0].getMarca() + "\n" +
                "Any de matriculació: " + anyMatriculacio + "\n";

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
