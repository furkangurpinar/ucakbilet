package com.example.ucakbilet.dao.impl;



import com.example.ucakbilet.dao.AirportDAO;
import com.example.ucakbilet.entity.Airport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirportDAOImpl implements AirportDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Airport> getAirports() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query<Airport> theQuery = currentSession.createQuery("from Airport ", Airport.class);

        List<Airport> airports = theQuery.getResultList();
        currentSession.getTransaction().commit();
        return airports;
    }

    @Override
    public void saveAirport(Airport theAirport) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theAirport);
        currentSession.getTransaction().commit();

    }

    @Override
    public Airport getAirport(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Airport theAirport = currentSession.get(Airport.class, theId);
        currentSession.getTransaction().commit();
        return theAirport;
    }

    @Override
    public void deleteAirport(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Airport where id=:airportId");
        theQuery.setParameter("airportId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();


    }
}
