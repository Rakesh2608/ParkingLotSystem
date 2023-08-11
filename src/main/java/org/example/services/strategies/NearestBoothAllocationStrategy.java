package org.example.services.strategies;

import org.example.models.Gate;
import org.example.models.ParkingBooth;
import org.example.models.ParkingLot;
import org.example.models.enums.ParkingBoothStatus;
import org.example.models.enums.VehicleType;
import org.example.repositories.ParkingBoothRepository;
import org.example.repositories.ParkinglotRepository;

import java.util.List;

public class NearestBoothAllocationStrategy implements BoothAllocationStrategy {

    private ParkingBoothRepository parkingBoothRepository;
    private ParkinglotRepository parkinglotRepository;

    public NearestBoothAllocationStrategy(ParkinglotRepository parkinglotRepository,
                                          ParkingBoothRepository parkingBoothRepository) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkingBoothRepository = parkingBoothRepository;
    }

    @Override
    public ParkingBooth assignBooth(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkinglotRepository.getByGateId(gate.getId());
        List<ParkingBooth> parkingBooth = parkingBoothRepository.getAllBoothByParkingLotId(parkingLot.getId());

        for (ParkingBooth booths : parkingBooth) {
            if (booths.getParkingBoothStatus().equals(ParkingBoothStatus.AVAILABLE) &&
                    booths.getSupportedVehicleType().equals(vehicleType)) {
                return booths;
            }
        }
    return null;
    }
}
