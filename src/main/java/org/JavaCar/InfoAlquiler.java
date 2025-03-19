package org.JavaCar;

import java.io.Serializable;

public class InfoAlquiler implements Serializable {
    private Vehicle vehicle;
    private int diesAlquilats;

    public InfoAlquiler(Vehicle vehicle, int diesAlquilats) {
        this.vehicle = vehicle;
        this.diesAlquilats = diesAlquilats;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDiesAlquilats() {
        return diesAlquilats;
    }
}
