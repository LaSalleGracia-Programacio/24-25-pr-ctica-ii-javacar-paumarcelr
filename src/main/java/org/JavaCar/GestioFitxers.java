package org.JavaCar;

import java.io.*;
import java.util.*;

public class GestioFitxers {

    static String nomFitxer = "vehicles.dat";
    public static void escriureVehicle(Vehicle vehicle, int dies, Client client) {
        File file = new File(nomFitxer);
        //Mirem si el fitxer existeix
        boolean afegir = file.exists();

        try {
            FileOutputStream fitxer = new FileOutputStream(file, afegir);
            ObjectOutputStream escritorFitxer;
            //Si el fitxer existeix, afegim al final del fitxer
            //Si no existeix, creem un nou fitxer i escribim
            if (afegir)
            {
                escritorFitxer = new AfegirFinalFitxer(fitxer);
            } else
            {
                escritorFitxer = new ObjectOutputStream(fitxer);
            }
            //Posem la informacio a escriure en el fitxer
            InfoAlquiler info = new InfoAlquiler(vehicle, dies, client);
            escritorFitxer.writeObject(info);
        } catch (IOException e) {
            System.out.println("Error al escriure el fitxer. Si el fitxer s'ha creat, borra el fitxer si us plau");
        }
    }

    public static List<InfoAlquiler> llegirVehicles() {
        List<InfoAlquiler> infoList = new ArrayList<>();
        try {
            //Obrim un lector de fitxer
            ObjectInputStream lectorFitxer = new ObjectInputStream(new FileInputStream(nomFitxer));
            //Mentres hi hagi linies en el fitxer, anem llegint
            while (true) {
                try {
                    InfoAlquiler info = (InfoAlquiler) lectorFitxer.readObject();
                    infoList.add(info);
                } catch (EOFException eof) {
                    // Ha arribat al final del fitxer. Sortim del bucle
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al llegir el fitxer o fitxer no trobat");
        }
        return infoList;
    }
}

