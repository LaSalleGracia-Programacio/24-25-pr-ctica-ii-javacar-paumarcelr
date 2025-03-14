package org.JavaCar;

public abstract class  Vehicle {
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preubase;

    public Vehicle(String matricula, String marca, String model, double preubase) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preubase = preubase;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPreubase() {
        return preubase;
    }

    public void setPreubase(double preubase) {
        this.preubase = preubase;
    }
}
