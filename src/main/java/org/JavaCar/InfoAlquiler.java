package org.JavaCar;

import java.io.Serializable;

//Classe Wrapper
//Ens ajuda a poder escriure informacio a fitxers de manera facil
public class InfoAlquiler implements Serializable {
    private Vehicle vehicle;
    private Client client;
    private int diesAlquilats;

    public InfoAlquiler(Vehicle vehicle, int diesAlquilats, Client client) {
        this.vehicle = vehicle;
        this.diesAlquilats = diesAlquilats;
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDiesAlquilats() {
        return diesAlquilats;
    }

    public Client getClient() { return client; }
}
