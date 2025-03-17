package org.JavaCar;
import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {
    static public double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double preutotal = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            preutotal += vehicles.get(i).calcularPreu(dies);
        }
        return preutotal;
    }

    public static List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        List<Vehicle> flitrada = new ArrayList<>();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPreuBase() < preuMax)
                flitrada.add(vehicles.get(i));
        }
        return vehicles;
    }
}