package org.example.models;

import org.example.models.enums.ParkingBoothStatus;
import org.example.models.enums.VehicleType;

public class ParkingBooth extends  BaseModel{
    private String number;
    private VehicleType supportedVehicleType;
    private ParkingBoothStatus parkingBoothStatus;
    private ParkingLot parkingLot;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(VehicleType supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public ParkingBoothStatus getParkingBoothStatus() {
        return parkingBoothStatus;
    }

    public void setParkingBoothStatus(ParkingBoothStatus parkingBoothStatus) {
        this.parkingBoothStatus = parkingBoothStatus;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
