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
        if (autonomiaElectirc == 0) {
            return "Moto{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", cilindrada=" + cilindrada +
                    ", motor=" + motor +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';
        } else {
            return "Moto{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", cilindrada=" + cilindrada +
                    ", motor=" + motor +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", autonomiaElectirc=" + autonomiaElectirc +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';

        }
    }
}
