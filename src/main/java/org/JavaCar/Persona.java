package org.JavaCar;

public class Persona {
    protected int id;
    protected String nom;
    protected String cognom;

    public Persona(int id, String nom, String cognom) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }
}
