package org.JavaCar;

import java.util.ArrayList;
import java.util.List;

public class Main {
   static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {


    }
    public void creacioVehicles(){
        Motor motorGasolina = new Motor("Gasolina",123);
        Motor motorHibrid = new Motor("Diesel",100);
        Motor motorElectric = new Motor("Gasolina",225);
        Motor motorDiesel= new Motor("Diesel",200);

        Roda[] rodes1 = {new Roda("Michelin", 15), new Roda("Michelin", 15), new Roda("Michelin", 15), new Roda("Michelin", 15)};
        Roda[] rodes2 = {new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15), new Roda("Michelin Agilis", 15)};
        Roda[] rodesMoto = {new Roda("Michelin Pilot Road", 15), new Roda("Michelin Pilot Road", 15)};

        vehicles.add(new Cotxe("1234 MMM","Toyota","Corola",70,5,motorGasolina,rodes1));
        vehicles.add(new Cotxe("2222 FFF","Seat","Leon",50,5,motorHibrid,rodes1));
        vehicles.add(new Cotxe("3421 FFF","Tesla","S",80,5,motorElectric,rodes1));

        vehicles.add(new Furgoneta("5555 LPQ","Ford","Transit",80,1250,motorGasolina,rodes2));
        vehicles.add(new Furgoneta("5465 SSH","Nissan","Interstar",65,665,motorGasolina,rodes2));

        vehicles.add(new Moto("3241 ENP","Yamaha","R7",80,525,motorDiesel,rodesMoto));
        vehicles.add(new Moto("2141 ENP","Ducati","Monster",75,150,motorGasolina,rodesMoto));





    }
}