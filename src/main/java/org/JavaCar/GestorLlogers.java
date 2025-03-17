package org.JavaCar;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestorLlogers {
    static Scanner input = new Scanner(System.in);
    static public double calcularIngressosTotals(ArrayList<Vehicle> vehicles, int dies) {
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
    public static void alquilarVehicle(List<Vehicle> vehiclesDisp, List<Vehicle> vAlquilats) {
        String s = "p";
        boolean trobat = false;
        int indice = -1;
        do {

            System.out.print("Introdueix la matricula del vehicle que vols alquilar: ");
            String matricula = input.nextLine();

            // buscar el cotxe a la llista de vehicles disponibles a partir de la matricula
            for (int i = 0; i < vehiclesDisp.size(); i++) {
                // si coincideix calculem el preu a partir dels dies
                if (matricula.equals(vehiclesDisp.get(i).matricula)) {
                    indice = i;
                    trobat = true;
                    break;
                }
            }
            if (trobat) {
                System.out.println("Quants dies el vols alquilar? ");
                int dies = input.nextInt();
                // mostrem el preu del cotxe que ha dit. Userfrendly mostrant marca i model
                double preu = vehiclesDisp.get(indice).calcularPreu(dies);
                System.out.println("El preu final del " + vehiclesDisp.get(indice).getMarca() + " " + vehiclesDisp.get(indice).getModel() + " és de :" + preu + "€");
                // si confirma li mostrem missatge de confirmació, eliminem el cotxe de la llista de desponibles i l'agrfim a la llista d'alquilats
                vAlquilats.add(vehiclesDisp.get(indice));
                vehiclesDisp.remove(indice);
                System.out.println("Cotxe alquilat correctament :)");
            } else {
                System.out.println("Matricula no trobada");
            }
        } while (!trobat);
    }
}