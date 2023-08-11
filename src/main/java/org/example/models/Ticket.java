package org.example.models;

import org.example.models.enums.VehicleType;

import java.util.Date;

public class Ticket extends BaseModel {
    private Date entryTime;
    private ParkingBooth assignedParkingBooth;
    private Gate entryGate;
    private Operator currentOperator;
    private Vehicle vehicle;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingBooth getAssignedParkingBooth() {
        return assignedParkingBooth;
    }

    public void setAssignedParkingBooth(ParkingBooth assignedParkingBooth) {
        this.assignedParkingBooth = assignedParkingBooth;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
