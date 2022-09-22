package com.example.ucakbilet.restController;

import com.example.ucakbilet.entity.Ticket;
import com.example.ucakbilet.exception.ticket.TicketNotFoundException;
import com.example.ucakbilet.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @GetMapping("/tickets")
    public List<Ticket> getAirplanes(){
        return ticketService.getTickets();
    }
    @GetMapping("/tickets/{ticketId}")
    public Ticket getAirplane(@PathVariable int ticketId){
        Ticket theTicket = (Ticket) ticketService.getTicket(ticketId);
        if(theTicket== null){
            throw new TicketNotFoundException("ticket id not found - "+ticketId);
        }
        return theTicket;
    }
    @PostMapping("/tickets")
    public Ticket addTicket(@RequestBody Ticket theTicket){
        theTicket.setId(0);
        ticketService.saveTicket(theTicket);
        return theTicket;
    }
    @PutMapping("/tickets")
    public Ticket updateTicket(@RequestBody Ticket theTicket){
        ticketService.saveTicket(theTicket);
        return theTicket;
    }
    @DeleteMapping("/tickets/{ticketId}")
    public String deleteAirplane(@PathVariable int ticketId){

        Ticket tempTicket = (Ticket) ticketService.getTicket(ticketId);

        //throw exception if null
        if(tempTicket== null){
            throw new TicketNotFoundException("Ticket id not found - "+ticketId);
        }
        ticketService.deleteTicket(ticketId);


        return "deleted Ticket id -" + ticketId;
    }
}
