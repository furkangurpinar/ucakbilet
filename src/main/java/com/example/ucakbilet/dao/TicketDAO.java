package com.example.ucakbilet.dao;



import com.example.ucakbilet.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> getTickets();

    void saveTicket (Ticket theTicket);

    TicketDAO getTicket(int theId);

    void deleteTicket(int theId);
}
