package org.JavaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);
    private String dni;
    private String nom;
    private String cognom;
    private  List<Vehicle> vehiclesClient;

    public Client(String dni, String nom, String cognom) {
        this.dni = dni;
        this.nom = nom;
        this.cognom = cognom;
        this.vehiclesClient = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public List<Vehicle> getVehiclesClient() {
        return this.vehiclesClient;
    }

    public void tornarVehicle(List<Vehicle> vehicles, List<Vehicle> vAlquilats) {
        veureVehiclesPropis();
        int indice = -1;
        if (vehiclesClient.isEmpty()){
            System.out.println("No tens ningun vehicle alquilat");
        } else{

            do {
                String matricula = Main.preguntarMatricula("Introdueix la matricula del vehicle que vols tornar: ");
                 indice = Main.buscarVehicle(vehiclesClient, matricula);

                if (indice != -1) {
                    Vehicle vehicle = vehiclesClient.get(indice);
                    System.out.println("Vehicle tornat correctament :)");
                    vehicles.add(vehicle);
                    vAlquilats.remove(vehicle);
                    vehiclesClient.remove(vehicle);


                } else {
                    System.out.println("Matricula no trobada");
                }
            } while (indice == -1);

        }

    }
    public  void alquilarVehicle(List<Vehicle> vehiclesDisp, List<Vehicle> vAlquilats) {
        int indice;
        int dies = 0;
        System.out.println("Aquest són els vehicles que tens disponibles");
        Main.mostrarVehicles(vehiclesDisp);

        do {
            String matricula = Main.preguntarMatricula("Introdueix la matricula del vehicle que vols alquilar: ");
            // buscar el cotxe a la llista de vehicles disponibles a partir de la matricula
            indice = Main.buscarVehicle(vehiclesDisp,matricula);
            if (indice != -1) {

                dies = Main.controlErrorsInt("Quants dies el vols alquilar? ",1,30);

                Vehicle vehicle = vehiclesDisp.get(indice);
                // mostrem el preu del cotxe que ha dit. Userfrendly mostrant marca i model
                double preu = vehicle.calcularPreu(dies);
                System.out.println("El preu final del " + vehicle.getMarca() + " " + vehicle.getModel() + " és de :" + preu + "€");
                // si confirma li mostrem missatge de confirmació, eliminem el cotxe de la llista de desponibles i l'agrfim a la llista d'alquilats


                generarFactura(vehicle, dies);
                vAlquilats.add(vehicle);
                vehiclesClient.add(vehicle);
                vehiclesDisp.remove(indice);

                System.out.println("Vehicle alquilat correctament :)");


            } else {
                System.out.println("Matricula no trobada");
            }

        } while ( indice == -1) ;
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

    public void filtrarVehicles(List<Vehicle> vehicles){
        System.out.println("Quin és el preu màxim que vols establir?");
        double preuMax = input.nextDouble();
        List<Vehicle> filtrada = GestorLloguers.filtrarPerPreu(vehicles,preuMax);
        if (filtrada.isEmpty()){
            System.out.println("No hi han vehicles disponibles per aquest preu");
        } else {
            for (int i = 0; i < filtrada.size(); i++) {
                System.out.println(filtrada.get(i).toString());
            }
        }
    }
    @Override
    public String toString() {
        return "Client{" +
                "vehiclesClient=" + vehiclesClient +
                ", dni=" + dni +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                '}';
    }

    public static Client comprovacioClient(List<Client> clients){
        int index = -1;

        do {
        // demanem credencials
        System.out.print("Introdueix el teu nom: ");
        String nom = input.nextLine();

        System.out.print("Introdueix el teu DNI: ");
        String dni = input.nextLine();
        // fem un bucle for amb una doble condicio per comprobar si les dos credencials coincideixen
        for (int i = 0; i < clients.size(); i++) {
            if (nom.equalsIgnoreCase(clients.get(i).getNom())){
                if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                    index = i;
                    break;
                }
                }
            }
        if (index !=-1){
            return clients.get(index);
        } else {
            System.out.println("DNI o nom incorrecte");
        }

        }  while (index == -1);

        return null;
    }
    public void veureVehiclesPropis(){
        if (vehiclesClient.isEmpty()){
            System.out.println("Encara no tens vehicles alquilats.");
        } else {
            if (vehiclesClient.size() >= 3){
                System.out.println("Wow "+getNom()+" ! Tens "+vehiclesClient.size()+"  vehicles alquilats.");
                System.out.println("Aqui tens la informació dels vehicles: ");
            } else {
                System.out.println("Aquest son els teus vehicles: ");
            }

            for (int i = 0; i < vehiclesClient.size(); i++) {
                System.out.println(vehiclesClient.get(i).toString());
            }
        }
    }
    public void vehiclesPerTipus(List<Vehicle> vehicleList) {
        int menu = Main.controlErrorsInt("Quin tipus de vehicle vols veure ?"+
                "\n 1- Motos"+
                "\n 2- Cotxes"+
                "\n 3- Furgonetes"+
                "\n 4- Sortir",1,4);
        switch (menu){
            case 1:
                mostrarPerTipus(vehicleList,Moto.class,"Aquí tens totes les motos disponibles. ");
                break;
            case 2:
                mostrarPerTipus(vehicleList,Cotxe.class,"Aquí tens tots el cotxes disponibles:");
                break;
            case 3:
                mostrarPerTipus(vehicleList,Furgoneta.class,"Aqui tens totes les furgonetes disponibles: ");
                break;
            case 4:
                break;
        }

    }
    private void mostrarPerTipus(List<Vehicle> vehicleList, Class<?> tipus, String missatge) {
        List<Vehicle> vehiclesTipus = new ArrayList<>();
        System.out.println(missatge);
        for (int i = 0; i < vehicleList.size(); i++) {
            if (tipus.isInstance(vehicleList.get(i))){
                vehiclesTipus.add(vehicleList.get(i));
            }
        }
        if (vehiclesTipus.isEmpty()){
            System.out.println("En aquest moment no hi han disponibles");
        } else {
            for (int i = 0; i < vehiclesTipus.size(); i++) {
                System.out.println(vehiclesTipus.get(i).toString());
            }
        }
    }
    public  void menuClient(List<Vehicle> vehicles,List<Vehicle> vAlquilats) {
        boolean sortir = false;
        do {

            int menu = Main.controlErrorsInt("Venvingut a javaCar " + getNom()+", les opcions del menú són: " +
                    "\n 1- Alquilar vehicle" +
                    "\n 2- Veure vehicles disponibles" +
                    "\n 3- Filtrar vehicles per preu" +
                    "\n 4- Filtrar vehicles per tipus"+
                    "\n 5- Veure els meus vehicles"+
                    "\n 6- Tornar vehicle alquilat"+
                    "\n 7- Sortir", 1, 7);

            switch (menu) {
                case 1:
                    alquilarVehicle(vehicles,vAlquilats);
                    break;
                case 2:
                    Main.mostrarVehicles(vehicles);
                    break;
                case 3:
                    filtrarVehicles(vehicles);
                    break;
                case 4:
                    vehiclesPerTipus(vehicles);
                    break;
                case 5:
                    veureVehiclesPropis();
                    break;
                case 6:
                    tornarVehicle(vehicles,vAlquilats);
                    break;
                case 7:
                    sortir = true;
                    break;
            }
        } while (!sortir);
    }

}
