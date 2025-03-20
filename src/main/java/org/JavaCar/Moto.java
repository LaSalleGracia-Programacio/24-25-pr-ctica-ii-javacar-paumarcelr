package org.JavaCar;

import java.util.Arrays;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }
    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public double calcularPreu(int dies) {
        if (cilindrada >500)
        {
            return (preuBase + 5) * dies;
        } else {
            return super.calcularPreu(dies);
        }
    }

    @Override
    public String toString() {
        String motoInfo = "Marca: " + marca + "\n" +
                "Model: " + model + "\n" +
                "Matricula: " + matricula + "\n" +
                "Preu/dia: " + preuBase + "\n" +
                "Cilindrada: " + cilindrada + "\n" +
                "Tipus de motor: " + motor.getTipus() + "\n" +
                "Marca de roda: " + rodes[0].getMarca() + "\n" +
                "Any de matriculació: " + anyMatriculacio + "\n";

        if (enchufable)
        {
            motoInfo += "És enchufable \n";
        }

        if (autonomiaElectirc != 0)
        {
            motoInfo += "Velocitat en autonomia electrica: " + autonomiaElectirc  +"\n";
        }

        motoInfo += "Eriqueta ambiental: " + etiqueta.toString();
        return  motoInfo;
    }
}
