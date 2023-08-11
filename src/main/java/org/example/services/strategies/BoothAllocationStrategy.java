package org.example.services.strategies;

import org.example.models.Gate;
import org.example.models.ParkingBooth;
import org.example.models.enums.VehicleType;

public interface BoothAllocationStrategy {

    public ParkingBooth assignBooth(VehicleType vehicleType, Gate gate);
}
