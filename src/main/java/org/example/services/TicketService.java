package org.example.services;

import org.example.exceptions.BoothNotAvailableException;
import org.example.exceptions.GateNotFoundException;
import org.example.models.Gate;
import org.example.models.ParkingBooth;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.models.enums.VehicleType;
import org.example.repositories.TicketRepository;
import org.example.services.strategies.BoothAllocationStrategy;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private GateService gateService;
    private VehicleService vehicleService;
    private BoothAllocationStrategy boothAllocationStrategy;

    public TicketService(TicketRepository ticketRepository, GateService gateService, VehicleService vehicleService,BoothAllocationStrategy boothAllocationStrategy) {
        this.ticketRepository = ticketRepository;
        this.gateService = gateService;
        this.vehicleService = vehicleService;
        this.boothAllocationStrategy=boothAllocationStrategy;
    }

    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws GateNotFoundException,BoothNotAvailableException {
        //get the gate object from gate service.
        Gate gate = gateService.getGateById(gateId);
        Vehicle vehicle = vehicleService.getVehicleByNumber(vehicleNumber, vehicleType);

        ParkingBooth assignBooth= boothAllocationStrategy.assignBooth(vehicleType,gate);
        if(assignBooth==null){
            throw  new BoothNotAvailableException();
        }
        Ticket ticket = new Ticket();
        ticket.setEntryGate(gate);
        ticket.setVehicle(vehicle); //register new Vehicle
        ticket.setEntryTime(new Date());
        ticket.setCurrentOperator(gate.getCurrentOperator());//set the current operator
        ticket.setAssignedParkingBooth(assignBooth);

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }


}
