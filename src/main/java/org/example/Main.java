package org.example;

import org.example.controllers.TicketController;
import org.example.dtos.GenerateTicketRequestDTO;
import org.example.dtos.GenerateTicketResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.models.enums.VehicleType;
import org.example.repositories.*;
import org.example.services.GateService;
import org.example.services.TicketService;
import org.example.services.VehicleService;
import org.example.services.strategies.BoothAllocationStrategy;
import org.example.services.strategies.NearestBoothAllocationStrategy;

public class Main {
    public static void main(String[] args) {

        VehicleRepository vehicleRepository=new VehicleRepository();
        VehicleService vehicleService=new VehicleService(vehicleRepository);
        GateRepository gateRepository=new GateRepository();
        GateService gateService=new GateService(gateRepository);
        TicketRepository ticketRepository=new TicketRepository();
        ParkinglotRepository parkinglotRepository=new ParkinglotRepository();
        ParkingBoothRepository parkingBoothRepository=new ParkingBoothRepository();
        BoothAllocationStrategy boothAllocationStrategy=new NearestBoothAllocationStrategy(parkinglotRepository,parkingBoothRepository);
        TicketService ticketService=new TicketService(ticketRepository,gateService,vehicleService,boothAllocationStrategy);
        TicketController ticketController=new TicketController(ticketService);

        GenerateTicketRequestDTO ticketRequestDTO=new GenerateTicketRequestDTO();
        ticketRequestDTO.setVehicleNumber("JH09h6756");
        ticketRequestDTO.setVehicleType(VehicleType.MEDIUM);
        ticketRequestDTO.setGateId(10L);

        GenerateTicketResponseDTO responseDTO=ticketController.generateTicket(ticketRequestDTO);

        if(responseDTO.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(responseDTO.getMessage());
        }
        System.out.println("Ticket generated Successfully"+responseDTO.getGeneratedTicketId());

    }
}