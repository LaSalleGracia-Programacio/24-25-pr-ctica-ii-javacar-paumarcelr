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
        if (autonomiaElectirc == 0) {
            return "Cotxe{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", motor=" + motor +
                    ", nombrePlaces=" + nombrePlaces +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';
        } else {
            return "Cotxe{" +
                    ", matricula='" + matricula + '\'' +
                    ", marca='" + marca + '\'' +
                    ", model='" + model + '\'' +
                    ", preuBase=" + preuBase +
                    ", motor=" + motor +
                    ", nombrePlaces=" + nombrePlaces +
                    ", rodes=" + Arrays.toString(rodes) +
                    ", enchufable=" + enchufable +
                    ", autonomiaElectirc=" + autonomiaElectirc +
                    ", anyMatriculacio=" + anyMatriculacio +
                    ", etiqueta=" + etiqueta +
                    '}';

        }
    }
}
