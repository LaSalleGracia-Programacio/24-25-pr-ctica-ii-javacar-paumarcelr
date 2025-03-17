package org.JavaCar;

public class Furgoneta extends Vehicle{
    private int capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }

    public int getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (capacitatCarga >1000)
        {
            return (preuBase + 10) * dies;
        } else {
            return super.calcularPreu(dies);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
