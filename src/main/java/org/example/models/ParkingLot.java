package org.example.models;

import java.util.List;

public class ParkingLot extends  BaseModel {
    private String name;
    private String address;
    private List<ParkingBooth> parkingBooths;

    private List<Gate> gates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingBooth> getParkingBooths() {
        return parkingBooths;
    }

    public void setParkingBooths(List<ParkingBooth> parkingBooths) {
        this.parkingBooths = parkingBooths;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }
}
