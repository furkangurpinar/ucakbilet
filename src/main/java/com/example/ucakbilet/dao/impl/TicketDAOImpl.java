package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.TicketDAO;
import com.example.ucakbilet.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Ticket> getTickets() {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query<Ticket> theQuery = currentSession.createQuery("from Ticket ", Ticket.class);

        List<Ticket> tickets = theQuery.getResultList();

        currentSession.getTransaction().commit();

        return tickets;
    }



    @Override
    public void saveTicket(Ticket theTicket) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theTicket);

        currentSession.getTransaction().commit();

    }

    @Override
    public TicketDAO getTicket(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Ticket theTicket = currentSession.get(Ticket.class,theId);

        return (TicketDAO) theTicket;
    }

    @Override
    public void deleteTicket(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Ticket where id =:ticketId");

        theQuery.setParameter("ticketId", theId);

        theQuery.executeUpdate();

        currentSession.getTransaction().commit();

    }
}
