package org.JavaCar;

import java.io.*;
import java.util.*;

public class GestioFitxers {

    static String nomFitxer = "vehicles.dat";
    public static void escriureVehicle(Vehicle v, int dies) {
        File file = new File(nomFitxer);
        boolean append = file.exists();

        try (FileOutputStream fos = new FileOutputStream(file, append);
             ObjectOutputStream oos = append
                     ? new AfegirFinalFitxer(fos)
                     : new ObjectOutputStream(fos)) {
            InfoAlquiler info = new InfoAlquiler(v, dies);
            oos.writeObject(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

