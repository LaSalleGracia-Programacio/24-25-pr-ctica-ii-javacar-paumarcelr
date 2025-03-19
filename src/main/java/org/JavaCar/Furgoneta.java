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
        if (autonomiaElectirc == 0) {
            return "Furgoneta{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", motor=" + motor +
                    ", capacitatCarga=" + capacitatCarga +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';
        } else {
            return "Furgoneta{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", motor=" + motor +
                    ", capacitatCarga=" + capacitatCarga +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", autonomiaElectirc=" + autonomiaElectirc +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';
        }
    }
}
