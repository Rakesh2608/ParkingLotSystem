package org.example.services;

import org.example.models.Vehicle;
import org.example.models.enums.VehicleType;
import org.example.repositories.VehicleRepository;

import java.util.Optional;

public class VehicleService {
    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository=vehicleRepository;
    }

    public Vehicle getVehicleByNumber(String vehicleNumber, VehicleType vehicleType) {
        Optional<Vehicle> vehicleMapper=vehicleRepository.getVehicle(vehicleNumber);
        if(vehicleMapper.isEmpty()){
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);

            Vehicle savedVehicle=vehicleRepository.save(vehicle);
            return savedVehicle;
        }
        else{
            vehicleMapper.get();
        }
        return null;
    }
}
