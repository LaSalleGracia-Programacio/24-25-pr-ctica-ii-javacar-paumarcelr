package org.JavaCar;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AfegirFinalFitxer extends ObjectOutputStream {
    public AfegirFinalFitxer(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}
