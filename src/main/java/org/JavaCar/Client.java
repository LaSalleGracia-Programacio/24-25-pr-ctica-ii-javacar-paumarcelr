package org.JavaCar;

import java.util.List;

public class Client extends Persona {
    private List<Vehicle> vehiclesClient;

    public Client(int id, String nom, String cognom) {
        super(id, nom, cognom);
    }

    public List<Vehicle> getVehiclesClient() {
        return vehiclesClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "vehiclesClient=" + vehiclesClient +
                ", dni=" + dni +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                '}';
    }
}
