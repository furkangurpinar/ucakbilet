package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.AirplaneDAO;
import com.example.ucakbilet.entity.Airplane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AirplaneDAOImpl implements AirplaneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Airplane> getAirplanes() {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query<Airplane> theQuery = currentSession.createQuery("from Airplane ", Airplane.class);

        //execute query and get result list
        List<Airplane> airplanes = theQuery.getResultList();
        currentSession.getTransaction().commit();


        return airplanes;
    }

    @Override
    public void saveAirplane(Airplane theAirplane) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theAirplane);
        currentSession.getTransaction().commit();


    }

    @Override
    public Airplane getAirplane(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Airplane theAirplane = currentSession.get(Airplane.class, theId);
        currentSession.getTransaction().commit();


        return theAirplane;


    }

    @Override
    public void deleteAirplane(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query theQuery = currentSession.createQuery("delete from Airplane where id=:airplaneId");

        theQuery.setParameter("airplaneId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();


    }
}
