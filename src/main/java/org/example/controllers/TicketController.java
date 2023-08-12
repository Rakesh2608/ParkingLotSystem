package org.example.controllers;

import org.example.dtos.GenerateTicketRequestDTO;
import org.example.dtos.GenerateTicketResponseDTO;
import org.example.dtos.ResponseStatus;
import org.example.models.Ticket;
import org.example.models.enums.VehicleType;
import org.example.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }


    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO){
        GenerateTicketResponseDTO ticketResponseDTO=null;

        try {

            Ticket ticket=ticketService.generateTicket(requestDTO.getGateId(),requestDTO.getVehicleNumber(),requestDTO.getVehicleType());
            ticketResponseDTO.setGeneratedTicketId(ticket.getId());
            ticketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            ticketResponseDTO.setMessage("Ticket generated successfully!!!");

        }catch (Exception ex){

            ticketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            ticketResponseDTO.setMessage("Something went Wrong!!!");
        }
        return null;
    }

}
