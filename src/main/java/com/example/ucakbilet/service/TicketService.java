package com.example.ucakbilet.service;

import com.example.ucakbilet.dao.TicketDAO;
import com.example.ucakbilet.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTickets();

    void saveTicket (Ticket theTicket);

    TicketDAO getTicket(int theId);

    void deleteTicket(int theId);
}
