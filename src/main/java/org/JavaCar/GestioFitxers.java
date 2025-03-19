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

    public static List<InfoAlquiler> llegirVehicles() {
        List<InfoAlquiler> infoList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFitxer))) {
            while (true) {
                try {
                    InfoAlquiler info = (InfoAlquiler) ois.readObject();
                    infoList.add(info);
                } catch (EOFException eof) {
                    // End of file reached, break the loop.
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return infoList;
    }
}

