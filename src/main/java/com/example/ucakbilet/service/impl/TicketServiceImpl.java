package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.TicketDAO;
import com.example.ucakbilet.entity.Ticket;
import com.example.ucakbilet.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;
    @Override
    public List<Ticket> getTickets() {
        return ticketDAO.getTickets();
    }

    @Override
    public void saveTicket(Ticket theTicket) {
        ticketDAO.saveTicket(theTicket);

    }

    @Override
    public TicketDAO getTicket(int theId) {
        return ticketDAO.getTicket(theId);
    }

    @Override
    public void deleteTicket(int theId) {
        ticketDAO.deleteTicket(theId);

    }
}
