package org.JavaCar;

import java.util.List;
import java.util.Scanner;

public class Administrador {
    static Scanner input = new Scanner(System.in);
    private static String contrasenya = "admin1234";

    public static String getContrasenya() {
        return contrasenya;
    }

    public static void ingressosTotals(List<Vehicle> vehicles) {
        int dies = Main.controlErrorsInt("Quants dies estan els cotxes alquilats? (D'1 a 30 dies)", 1, 30);
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
            System.out.println(info.getClient().getNom());
        }
    }

    public static void calcularIngressosHistorial()
    {
        List<InfoAlquiler> historial = GestioFitxers.llegirVehicles();
        double ingressosTotals = 0;
        for (InfoAlquiler info : historial)
        {
            System.out.println(info.getVehicle().toString());
            System.out.println(info.getDiesAlquilats());
            ingressosTotals += info.getVehicle().getPreuBase() * info.getDiesAlquilats();
        }

        System.out.println("Els ingressos totals generats son de " + ingressosTotals + "€");
    }

    public static void menuAdmin(List<Vehicle> vAlquilats, List<Client> clients){
        boolean sortir = false;
        do {
            int menu = Main.controlErrorsInt("Que vols fer com Administrador a javCar" +
                    "\n 1- Veure ingresos totals" +
                    "\n 2- Veure vehicles Alquilats" +
                    "\n 3- Veure historial de vehicles alquilats de tots els usuaris" +
                    "\n 4- Calcular ingressos de l'historial de vehicles alquilats de tots els usuaris" +
                    "\n 5- Sortir", 1, 5);
            switch (menu) {
                case 1:
                    Administrador.ingressosTotals(vAlquilats);
                    break;
                case 2:
                    Administrador.veureVehiclesAlquilats(clients);
                    break;
                case 3:
                    Administrador.veureHistorialVehicles();
                    break;
                case 4:
                    Administrador.calcularIngressosHistorial();
                    break;
                case 5:
                    sortir = true;
                    break;

            }
        } while (!sortir);
    }

    public static boolean comprovacioAdmin() {
        boolean login = false;
        int intents = 0;
        while (intents < 3 && !login) {
            if (intents == 2) {
                System.out.println("Atenció!! És l'últim intent");
            }
            System.out.print("Escriu la contrasenya d'administradors: ");
            String contra = input.nextLine();
            if (contra.equalsIgnoreCase(getContrasenya())) {
                login = true;
            } else {
                intents++;
                System.out.println("Contrasenya invalida");

            }
        }
        return login;
    }
}
