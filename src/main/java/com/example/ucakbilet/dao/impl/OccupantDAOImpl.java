package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.OccupantDAO;
import com.example.ucakbilet.entity.Occupant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OccupantDAOImpl implements OccupantDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Occupant> getOccupants() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        //create a query

        Query<Occupant> theQuery =currentSession.createQuery("from Occupant ",Occupant.class);

        //execute query and get result list
        List<Occupant> occupants=theQuery.getResultList();
        currentSession.getTransaction().commit();


        return occupants;

    }

    @Override
    public void saveOccupant(Occupant theOccupant) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        //save/update the occupant
        currentSession.saveOrUpdate(theOccupant);
        currentSession.getTransaction().commit();


    }

    @Override
    public Occupant getOccupant(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        //retrieve/read from database using the pk
        Occupant theOccupant =currentSession.get(Occupant.class, theId);
        currentSession.getTransaction().commit();

        return theOccupant;

    }

    @Override
    public void deleteOccupant(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        //delete object with pk
        Query theQuery=currentSession.createQuery("delete from Occupant where id=:occupantId");

        theQuery.setParameter("occupantId",theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();


    }
}
