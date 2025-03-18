package org.JavaCar;

import java.util.List;
import java.util.Scanner;

public class Administrador extends Persona{
    static Scanner input = new Scanner(System.in);
    private int anysExperiencia;

    public Administrador(String dni, String nom, String cognom, int anysExperiencia) {
        super(dni, nom, cognom);
        this.anysExperiencia = anysExperiencia;
    }

    public int getAnysExperiencia() {
        return anysExperiencia;
    }
    public  void ingressosTotals(List<Vehicle> vehicles)
    {
        int dies = Main.controlErrosMenu("Quants dies estan els cotxes alquilats?", 1, 30);
        double ingressos = GestorLloguers.calcularIngressosTotals(vehicles, dies);
        System.out.println("Els ingressos totals actuals son: " + ingressos + "€");
    }
    public static Administrador comprovacioAdmin(List<Administrador> admins){
        int index = -1;

        do {
            // demanem credencials
            System.out.print("Introdueix el teu nom: ");
            String nom = input.nextLine();

            System.out.print("Introdueix el teu DNI: ");
            String dni = input.nextLine();
            // fem un bucle for amb una doble condicio per comprobar si les dos credencials coincideixen
            for (int i = 0; i < admins.size(); i++) {
                if (nom.equalsIgnoreCase(admins.get(i).getNom())){
                    if (dni.equalsIgnoreCase(admins.get(i).getDni())){
                        index = i;
                        break;
                    }
                }
            }
            if (index !=-1){
                return admins.get(index);
            } else {
                System.out.println("DNI o nom incorrecte");
            }

        }  while (index == -1);

        return null;
    }
}
