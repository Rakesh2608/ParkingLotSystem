package org.example.services.strategies;

import org.example.models.Gate;
import org.example.models.ParkingBooth;
import org.example.models.ParkingLot;
import org.example.models.enums.ParkingBoothStatus;
import org.example.models.enums.VehicleType;
import org.example.repositories.ParkingBoothRepository;
import org.example.repositories.ParkinglotRepository;

import java.util.Collections;
import java.util.List;

public class FurthestBoothAllocationStrategy implements BoothAllocationStrategy{

    private ParkingBoothRepository parkingBoothRepository;
    private ParkinglotRepository parkinglotRepository;
    public FurthestBoothAllocationStrategy(ParkingBoothRepository parkingBoothRepository,ParkinglotRepository parkinglotRepository){
        this.parkingBoothRepository=parkingBoothRepository;
        this.parkinglotRepository=parkinglotRepository;
    }
    @Override
    public ParkingBooth assignBooth(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot=parkinglotRepository.getByGateId(gate.getId());
        List<ParkingBooth> parkingBooths=parkingBoothRepository.getAllBoothByParkingLotId(parkingLot.getId());

        Collections.reverse(parkingBooths);
        for(ParkingBooth booth:parkingBooths){
            if(booth.getParkingBoothStatus().equals(ParkingBoothStatus.AVAILABLE)&&booth.getSupportedVehicleType().equals(vehicleType)){
                return booth;
            }
        }
        return null;
    }
}
