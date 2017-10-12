package com.lohika.java8workshop.stream;

import java.util.Arrays;
import java.util.List;

public class FleetFactory {

    public static List<Vehicle> get() {
        return Arrays.asList(
            new Vehicle("Mazda", true, 2000, Vehicle.Type.CAR),
            new Vehicle("Toyota", false, 1800, Vehicle.Type.CAR),
            new Vehicle("Volvo", true, 3800, Vehicle.Type.TRUCK),
            new Vehicle("Scania", false, 4000, Vehicle.Type.TRUCK),
            new Vehicle("Mann", false, 3900, Vehicle.Type.TRUCK),
            new Vehicle("Aston Martin", false, 5400, Vehicle.Type.CAR),
            new Vehicle("Nissan", true, 1200, Vehicle.Type.CAR),
            new Vehicle("Opel", true, 2500, Vehicle.Type.MINIBUS),
            new Vehicle("Mercedes", true, 2600, Vehicle.Type.MINIBUS),
            new Vehicle("Peugeot", true, 2000, Vehicle.Type.MINIBUS)
                            );
    }

}
