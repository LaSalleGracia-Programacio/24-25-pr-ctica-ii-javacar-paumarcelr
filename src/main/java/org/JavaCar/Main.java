package org.JavaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static List<Vehicle> vehicles = new ArrayList<>();
    static List<Vehicle> vAlquilats = new ArrayList<>();
    static List<Client> clients = new ArrayList<>();

    static Client c;


    public static void main(String[] args) {
        creacioVehicles();
        creacioPersones();
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

    public static void creacioPersones(){
        clients.add(new Client("12345678F","Marcel","Roquet"));
        clients.add(new Client("98765432M","Pau","Sole"));
        clients.add(new Client("12345678M","Cristina","Garcia"));
    }
    //Menus
    public static void menuClient() {
        boolean sortir = false;
        do {

            int menu = controlErrorsInt("Venvingut a javaCar " +c.getNom()+", les opcions del menú són: " +
                    "\n 1- Alquilar vehicle" +
                    "\n 2- Veure vehicles disponibles" +
                    "\n 3- Filtrar vehicles" +
                    "\n 4- Veure els meus vehicles"+
                    "\n 5- Tornar vehicle alquilat"+
                    "\n 6- Sortir", 1, 6);

            switch (menu) {
                case 1:
                    c.alquilarVehicle(vehicles,vAlquilats);
                    break;
                case 2:
                    mostrarVehicles(vehicles);
                    break;
                case 3:
                    c.filtrarVehicles(vehicles);
                    break;
                case 4:
                    c.veureVehiclesPropis();
                    break;
                case 5:
                    c.tornarVehicle(vehicles,vAlquilats);
                    break;
                case 6:
                    sortir = true;
                    break;
            }
        } while (!sortir);
    }
    public static void menuAdmin(){
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

    public static void adminOClient() {
        boolean sortir = false;
        do {
            int menu = controlErrorsInt("Que ets: " +
                    "\n 1- Client " +
                    "\n 2- Administrador" +
                    "\n 3- Sortir", 1, 3);
            switch (menu) {
                case 1:
                    c = Client.comprovacioClient(clients);
                    menuClient();
                    break;
                case 2:
                    Administrador.comprovacioAdmin();;
                    break;
                case 3:
                    sortir = true;
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (!sortir);
    }

    //Control d'errors
    static int controlErrorsInt(String missatge, int min, int max) {

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
    public static void mostrarVehicles(List<Vehicle> vehicles){
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }
    public static String preguntarMatricula(String missatge){
        System.out.print(missatge);
        String matricula = input.nextLine();
        return matricula;
    }
    public static int buscarVehicle(List<Vehicle> vehicleList, String matricula) {
        int indice = -1;

            // buscar el cotxe a la llista de vehicles alquilats   a partir de la matricula
            for (int i = 0; i < vehicleList.size(); i++) {
                // si coincideix calculem el preu a partir dels dies
                if (matricula.equalsIgnoreCase(vehicleList.get(i).getMatricula())) {
                    indice = i;
                    break;
                }
            }
            return indice;
        }
}