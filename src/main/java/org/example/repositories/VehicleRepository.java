package org.example.repositories;

import org.example.models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicleDBMock = new HashMap<>();
    private Long autoIncrement = 0L;


    public Vehicle save(Vehicle vehicle) {
        if (vehicle.getId() == null) {
            autoIncrement++;
            vehicle.setId(autoIncrement);
            vehicleDBMock.put(autoIncrement, vehicle);
        } else {
            vehicleDBMock.put(vehicle.getId(), vehicle);
        }
        return vehicle;
    }


    public Optional<Vehicle> getVehicle(String vehicleNumber) {
        for (Vehicle vehicle : vehicleDBMock.values()) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();

    }
}
