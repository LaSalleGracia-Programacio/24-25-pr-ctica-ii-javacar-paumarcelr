package org.JavaCar;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AfegirFinalFitxer extends ObjectOutputStream {
    public AfegirFinalFitxer(OutputStream out) throws IOException {
        super(out);
    }

    //Fer que quan escriu en un fitxer, no posar headers
    //Aixo es fa perque quan s'escriuen els vehicles d'un a un
    //Posa headers cada vegada que s'escriu
    //I dona errors a l'hora de llegir el fitxer
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}
