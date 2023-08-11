package org.example.repositories;

import org.example.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Long, Ticket> ticketDbMock = new HashMap<>();
    private Long autoIncrement = 0L;

    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            autoIncrement++;
            ticket.setId(autoIncrement);
            ticketDbMock.put(autoIncrement, ticket);

        } else {
            ticketDbMock.put(ticket.getId(), ticket);
        }
        return ticket;
    }
}
