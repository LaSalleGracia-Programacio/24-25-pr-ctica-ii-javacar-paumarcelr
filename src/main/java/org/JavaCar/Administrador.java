package org.JavaCar;

import java.util.List;
import java.util.Scanner;

public class Administrador {
    static Scanner input = new Scanner(System.in);
    private static String contrasenya = "Bro como va a ser esta la contraseña xdd 69";

    public static String getContrasenya() {
        return contrasenya;
    }

    public static void ingressosTotals(List<Vehicle> vehicles) {
        int dies = Main.controlErrosMenu("Quants dies estan els cotxes alquilats?", 1, 30);
        double ingressos = GestorLloguers.calcularIngressosTotals(vehicles, dies);
        System.out.println("Els ingressos totals actuals son: " + ingressos + "€");
    }


    public static void veureVehiclesAlquilats(List<Client> clients)
    {
        System.out.println("Els vehicles que actualment estan alquilats son:");
        for (Client c : clients)
        {
            System.out.println("Vehicles alquilats per " + c.getNom() + " " + c.getCognom() + ": ");
            for (Vehicle v : c.getVehiclesClient())
            {
                System.out.println(v.toString());
            }
        }
    }

    public static void veureHistorialVehicles()
    {
        List<InfoAlquiler> historial = GestioFitxers.llegirVehicles();

        for (InfoAlquiler info : historial)
        {
            System.out.println(info.getVehicle().toString());
            System.out.println(info.getDiesAlquilats());
        }

    }

    public static void comprovacioAdmin() {
        int intents = 0;
        while (intents < 3) {
            if (intents == 2) {
                System.out.println("Atenció!! És l'últim intent");
            }
            System.out.print("Escriu la contrasenya d'administradors: ");
            String contra = input.nextLine();
            if (contra.equalsIgnoreCase(getContrasenya())) {
                Main.menuAdmin();
                break;
            } else {
                intents++;
                System.out.println("Contrasenya invalida");
            }
        }
        
    }
}
