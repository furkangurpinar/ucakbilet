package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.PassengerDAO;
import com.example.ucakbilet.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Passenger> getPassengers() {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query<Passenger> theQuery = currentSession.createQuery("from Passenger ", Passenger.class);

        List<Passenger> passengers = theQuery.getResultList();

        currentSession.getTransaction().commit();

        return passengers;
    }

    @Override
    public void savePassenger(Passenger thePassenger) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        currentSession.saveOrUpdate(thePassenger);

        currentSession.getTransaction().commit();

    }

    @Override
    public Passenger getPassenger(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Passenger thePassenger = currentSession.get(Passenger.class, theId);

        currentSession.getTransaction().commit();

        return thePassenger;
    }

    @Override
    public void deletePassenger(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Passenger where id =:passengerId");

        theQuery.setParameter("passengerId", theId);

        theQuery.executeUpdate();

        currentSession.getTransaction().commit();

    }
}

