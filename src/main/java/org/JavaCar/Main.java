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

        /*1*/vehicles.add(new Cotxe("1234 MMM","Toyota","Corola",70,5,motorGasolina,rodes1));
        /*2*/vehicles.add(new Cotxe("2222 FFF","Seat","Leon",50,5,motorHibrid,rodes1));
        vehicles.get(1).setAnyMatriculacio(2013);
        vehicles.get(1).setEnchufable(true);
        vehicles.get(1).setAutonomiaElectirc(30);

        /*3*/vehicles.add(new Cotxe("3421 FFF","Tesla","S",80,5,motorElectric,rodes1));
        vehicles.get(2).setAnyMatriculacio(2022);
        vehicles.get(2).setEnchufable(true);
        vehicles.get(2).setAutonomiaElectirc(200);

       /*4*/ vehicles.add(new Furgoneta("5555 LPQ","Ford","Transit",80,1250,motorGasolina,rodes2));
        /*5*/vehicles.add(new Furgoneta("5465 SSH","Nissan","Interstar",65,665,motorGasolina,rodes2));
        vehicles.get(3).setAnyMatriculacio(1999);
        vehicles.get(4).setAnyMatriculacio(2008);

       /*6*/ vehicles.add(new Moto("3241 ENP","Yamaha","R7",80,525,motorDiesel,rodesMoto));
        /*7*/vehicles.add(new Moto("2141 ENP","Ducati","Monster",75,150,motorGasolina,rodesMoto));
        vehicles.get(5).setAnyMatriculacio(2002);
        vehicles.get(6).setAnyMatriculacio(2014);

        /*8*/vehicles.add(new Cotxe("5678 ABC", "Honda", "Civic", 75, 5, motorDiesel, rodes1));
        /*9*/vehicles.add(new Cotxe("9101 DEF", "Ford", "Focus", 68, 5, motorHibrid, rodes1));
        /*10*/vehicles.add(new Cotxe("1121 GHI", "Volkswagen", "Golf", 80, 5, motorElectric, rodes1));

        vehicles.get(7).setAnyMatriculacio(2012);

        vehicles.get(8).setAnyMatriculacio(2018);
        vehicles.get(8).setAutonomiaElectirc(20);

        vehicles.get(9).setAnyMatriculacio(2024);
        vehicles.get(9).setEnchufable(true);
        vehicles.get(9).setAutonomiaElectirc(500);

        /*11*/vehicles.add(new Furgoneta("8093 RPG", "Mercedes-Benz", "Vito", 45, 698, motorGasolina, rodes2));

        vehicles.get(10).setAnyMatriculacio(1990);

       /*12*/ vehicles.add(new Furgoneta("3765 ZXC", "Renault", "Trafic", 48, 720, motorHibrid, rodes2));

        vehicles.get(11).setAnyMatriculacio(2017);
        vehicles.get(11).setAutonomiaElectirc(35);

       /*13*/ vehicles.add(new Moto("8891 TGH", "Kawasaki", "Z650", 78, 200, motorHibrid, rodesMoto));

        vehicles.get(12).setAnyMatriculacio(2025);
        vehicles.get(12).setEnchufable(true);
        vehicles.get(12).setAutonomiaElectirc(90);

        /*14*/vehicles.add(new Moto("6672 BVC", "BMW", "F 900 R", 82, 220, motorElectric, rodesMoto));

        vehicles.get(13).setAnyMatriculacio(2025);
        vehicles.get(13).setEnchufable(true);
        vehicles.get(13).setAutonomiaElectirc(450);



    }

    public static void creacioPersones(){
        clients.add(new Client(".","Marcel","Roquet"));
        clients.add(new Client("98765432M","Pau","Sole"));
        clients.add(new Client("12345678M","Cristina","Garcia"));
    }
    //Menus


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
                    if (c != null)
                    {
                        c.menuClient(vehicles,vAlquilats);
                    }
                    break;
                case 2:
                    if (Administrador.comprovacioAdmin())
                    {
                        Administrador.menuAdmin(vAlquilats, clients);
                    } else {
                        System.out.println("Mira la contrasenya i tonra-ho a intentar");
                    }
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
}