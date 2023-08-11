package org.example.models;

import org.example.models.enums.VehicleType;

public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private VehicleType vehicleType;

    public String getVehicleNumber() {return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}