package org.JavaCar;

public abstract class Persona {
    protected int dni;
    protected String nom;
    protected String cognom;

    public Persona(int id, String nom, String cognom) {
        this.dni = id;
        this.nom = nom;
        this.cognom = cognom;
    }

    public int getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                '}';
    }
}
