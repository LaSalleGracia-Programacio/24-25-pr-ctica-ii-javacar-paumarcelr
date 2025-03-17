package org.JavaCar;
public abstract class  Vehicle implements Llogable{
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;

    protected boolean enchufable;
    protected double autonomiaElectirc;
    protected int anyMatriculacio;

    protected EtiquetaAmbiental etiqueta;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;

        enchufable = false;
        autonomiaElectirc = 160;
        anyMatriculacio = 1995;
    }

    public double calcularPreu(int dies) {
        return preuBase * dies;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public EtiquetaAmbiental getEtiqueta() {
        return etiqueta;
    }

    public boolean isEnchufable() {
        return enchufable;
    }

    public void setEnchufable(boolean enchufable) {
        this.enchufable = enchufable;
    }

    public double getAutonomiaElectirc() {
        return autonomiaElectirc;
    }

    public void setAutonomiaElectirc(double autonomiaElectirc) {
        this.autonomiaElectirc = autonomiaElectirc;
    }

    public int getAnyMatriculacio() {
        return anyMatriculacio;
    }

    public void setAnyMatriculacio(int anyMatriculacio) {
        this.anyMatriculacio = anyMatriculacio;
    }


}
