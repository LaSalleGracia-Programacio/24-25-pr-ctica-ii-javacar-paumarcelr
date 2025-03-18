package org.JavaCar;

import java.util.List;

public class Administrador extends Persona{
    private int anysExperiencia;

    public Administrador(String dni, String nom, String cognom, int anysExperiencia) {
        super(dni, nom, cognom);
        this.anysExperiencia = anysExperiencia;
    }

    public int getAnysExperiencia() {
        return anysExperiencia;
    }
    public static void ingressosTotals(List<Vehicle> vehicles)
    {
        int dies = Main.controlErrosMenu("Quants dies estan els cotxes alquilats?", 1, 30);
        double ingressos = GestorLloguers.calcularIngressosTotals(vehicles, dies);
        System.out.println("Els ingressos totals actuals son: " + ingressos + "€");
    }
}
