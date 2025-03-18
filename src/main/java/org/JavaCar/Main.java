package org.JavaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
   static List<Vehicle> vehicles = new ArrayList<>();
    static List<Vehicle> vAlquilats = new ArrayList<>();

    public static void main(String[] args) {
        creacioVehicles();
        adminOClient();

    }
    public static void creacioVehicles(){
        Motor motorGasolina = new Motor("Gasolina",123);
        Motor motorHibrid = new Motor("Hibrid",100);
        Motor motorElectric = new Motor("Electric",225);
        Motor motorDiesel= new Motor("Diesel",200);

        Roda[] rodes1 = {new Roda("Michelin", 15), new Roda("Michelin", 15), new Roda("Michelin", 15), new Roda("Michelin", 15)};
        Roda[] rodes2 = {new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15)};
        Roda[] rodesMoto = {new Roda("Michelin Pilot Road", 15), new Roda("Michelin Pilot Road", 15)};

        vehicles.add(new Cotxe("1234 MMM","Toyota","Corola",70,5,motorGasolina,rodes1));
        vehicles.add(new Cotxe("2222 FFF","Seat","Leon",50,5,motorHibrid,rodes1));
        vehicles.add(new Cotxe("3421 FFF","Tesla","S",80,5,motorElectric,rodes1));

        vehicles.add(new Furgoneta("5555 LPQ","Ford","Transit",80,1250,motorGasolina,rodes2));
        vehicles.add(new Furgoneta("5465 SSH","Nissan","Interstar",65,665,motorGasolina,rodes2));

        vehicles.add(new Moto("3241 ENP","Yamaha","R7",80,525,motorDiesel,rodesMoto));
        vehicles.add(new Moto("2141 ENP","Ducati","Monster",75,150,motorGasolina,rodesMoto));
    }

    //Menus
    public static void menuClient() {
        boolean sortir = false;
        do {

            int menu = controlErrosMenu("Venvingut a javaCar, les opcions del menú són: " +
                    "\n 1- Alquilar vehicle" +
                    "\n 2- Veure vehicles disponibles" +
                    "\n 3- Filtrar vehicles" +
                    "\n 4- Tornar vehicle alquilat"+
                    "\n 4- Sortir", 1, 4);

            switch (menu) {
                case 1:
                    alquilarVehicle(vehicles,vAlquilats);
                    break;
                case 2:
                    mostrarVehicles(vehicles);
                    break;
                case 3:
                    filtrarVehicles();
                    break;
                case 4:
                    tornarVehicle();
                    break;
                case 5:
                    sortir = true;
                    break;
            }
        } while (!sortir);
    }

    private static void tornarVehicle() {
        String s ;
        boolean trobat = false;
        int indice = -1;
        int dies = 0;
        do {
            System.out.print("Introdueix la matricula del vehicle que vols tornar: ");
            String matricula = input.nextLine();

            // buscar el cotxe a la llista de vehicles alquilats   a partir de la matricula
            for (int i = 0; i < vAlquilats.size(); i++) {
                // si coincideix calculem el preu a partir dels dies
                if (matricula.equals(vAlquilats.get(i).matricula)) {
                    indice = i;
                    trobat = true;
                    break;
                }
            }
            if (trobat) {
                System.out.println("Cotxe tornat correctament :)");
                vehicles.add(vAlquilats.get(indice));
                vAlquilats.remove(indice);

            } else {
                System.out.println("Matricula no trobada");
            }
        } while (!trobat);
    }

    public static void menuAdmin(){
        boolean sortir = false;
        do {
            int menu = controlErrosMenu("Que vols fer com Administrador a javCar" +
                    "\n 1- Veure ingresos totals" +
                    "\n 2- Veure vehicles Alquilats" +
                    "\n 3- Veure historial de vehicles" +
                    "\n 4- Sortir", 1, 4);
            switch (menu) {
                case 1:
                    ingressosTotals();
                    break;
                case 2:
                    veureVehiclesAlquilats();
                    break;
                case 3:
                    break;
                case 4:
                    sortir = true;
                    break;

            }
        } while (!sortir);
    }
    public static void adminOClient() {
        boolean sortir = false;
        do {
            int menu = controlErrosMenu("Que ets: " +
                    "\n 1- Client " +
                    "\n 2- Administrador" +
                    "\n 3- Sortir", 1, 3);
            switch (menu) {
                case 1:
                    menuClient();
                    break;
                case 2:
                    menuAdmin();
                    break;
                case 3:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (!sortir);
    }

    //Control d'errors
    private static int controlErrosMenu(String missatge, int min, int max) {

        int x = 0;
        boolean valorCorrecte = false;

        do {
            System.out.println(missatge);
            valorCorrecte = input.hasNextInt();

            if (!valorCorrecte) {
                System.out.println("ERROR: Valor no enter.");
                input.nextLine();
            } else { // Tinc un enter
                x = input.nextInt();
                input.nextLine();
                if (x < min || x > max) {
                    System.out.println("Opció no valida");
                    valorCorrecte = false;
                }
            }
        } while (!valorCorrecte);

        return x;
    }

    //Funcions d'usuari
    public static void alquilarVehicle(List<Vehicle> vehiclesDisp, List<Vehicle> vAlquilats) {
        String s = "p";
        boolean trobat = false;
        int indice = -1;
        int dies = 0;
        do {
            System.out.println("Aquest són els vehicles que tens disponibles");
            mostrarVehicles(vehiclesDisp);
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
                dies = input.nextInt();
                // mostrem el preu del cotxe que ha dit. Userfrendly mostrant marca i model
                double preu = vehiclesDisp.get(indice).calcularPreu(dies);
                System.out.println("El preu final del " + vehiclesDisp.get(indice).getMarca() + " " + vehiclesDisp.get(indice).getModel() + " és de :" + preu + "€");
                // si confirma li mostrem missatge de confirmació, eliminem el cotxe de la llista de desponibles i l'agrfim a la llista d'alquilats

                System.out.println("Cotxe alquilat correctament :)");
                generarFactura(vehiclesDisp.get(indice), dies);
                vAlquilats.add(vehiclesDisp.get(indice));
                vehiclesDisp.remove(indice);

            } else {
                System.out.println("Matricula no trobada");
            }
        } while (!trobat);
    }
    public static void generarFactura(Vehicle vehicle,int dies){
        System.out.println("========================================");
        System.out.println("               FACTURA");
        System.out.println("========================================");
        System.out.println("Marca......: "+vehicle.getMarca());
        System.out.println("Model......: "+ vehicle.getModel());
        System.out.println("Preu Base..: "+vehicle.getPreuBase()+"€");
        System.out.println("Dies.......: "+dies);
        System.out.println("PvP........: "+vehicle.calcularPreu(dies)+"€");
        System.out.println("Gràcies per la seva compra ");
        System.out.println("========================================");
    }
    public static void mostrarVehicles(List<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }
    public static void filtrarVehicles(){
        System.out.println("Quin és el preu màxim que vols establir?");
        double preuMax = input.nextDouble();
       List<Vehicle> filtrada = GestorLloguers.filtrarPerPreu(vehicles,preuMax);
        for (int i = 0; i < filtrada.size(); i++) {
            System.out.println(filtrada.get(i).toString());
        }
    }

    //Funcions d'administrador/gestor
    public static void ingressosTotals()
    {
        int dies = controlErrosMenu("Quants dies estan els cotxes alquilats?", 1, 30);
        double ingressos = GestorLloguers.calcularIngressosTotals(vAlquilats, dies);
        System.out.println("Els ingressos totals actuals son: " + ingressos + "€");
    }

    public static void veureVehiclesAlquilats()
    {
        System.out.println("Els vehicles que actualment estan alquilats son:");
        for (Vehicle v : vAlquilats)
        {
            System.out.println(v.toString());
        }
    }
}