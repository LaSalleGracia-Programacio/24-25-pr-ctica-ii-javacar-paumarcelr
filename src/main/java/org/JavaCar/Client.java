package org.JavaCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends Persona {
    static Scanner input = new Scanner(System.in);
    private static List<Vehicle> vehiclesClient;

    public Client(String dni, String nom, String cognom) {
        super(dni, nom, cognom);
        this.vehiclesClient = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesClient() {
        return this.vehiclesClient;
    }

    public static void tornarVehicle(List<Vehicle> vehicles, List<Vehicle> vAlquilats) {
        String s ;
        boolean trobat = false;
        int indice = -1;
        int dies = 0;
        do {
            System.out.print("Introdueix la matricula del vehicle que vols tornar: ");
            String matricula = input.nextLine();

            // buscar el cotxe a la llista de vehicles alquilats   a partir de la matricula
            for (int i = 0; i < vehiclesClient.size() ; i++) {
                // si coincideix calculem el preu a partir dels dies
                if (matricula.equals(vehiclesClient.get(i).matricula)) {
                    indice = i;
                    trobat = true;
                    break;
                }
            }
            if (trobat) {
                System.out.println("Cotxe tornat correctament :)");
                vehicles.add(vehicles.get(indice));
                vehiclesClient.remove(indice);
                vAlquilats.remove(indice);

            } else {
                System.out.println("Matricula no trobada");
            }
        } while (!trobat);
    }
    public static void alquilarVehicle(List<Vehicle> vehiclesDisp, List<Vehicle> vAlquilats) {
        String s = "p";
        boolean trobat = false;
        int indice = -1;
        int dies = 0;
        do {
            System.out.println("Aquest són els vehicles que tens disponibles");
            Main.mostrarVehicles(vehiclesDisp);
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
                vehiclesClient.add(vAlquilats.get(indice));
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

    public static void filtrarVehicles(List<Vehicle> vehicles){
        System.out.println("Quin és el preu màxim que vols establir?");
        double preuMax = input.nextDouble();
        List<Vehicle> filtrada = GestorLloguers.filtrarPerPreu(vehicles,preuMax);
        for (int i = 0; i < filtrada.size(); i++) {
            System.out.println(filtrada.get(i).toString());
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

    }
}
