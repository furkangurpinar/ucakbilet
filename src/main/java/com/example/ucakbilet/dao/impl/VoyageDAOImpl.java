package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.VoyageDAO;
import com.example.ucakbilet.entity.Voyage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoyageDAOImpl implements VoyageDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Voyage> getVoyages() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query<Voyage> theQuery = currentSession.createQuery("from Voyage ", Voyage.class);

        //execute query and get result list
        List<Voyage> voyages = theQuery.getResultList();
        currentSession.getTransaction().commit();
        return voyages;
    }

    @Override
    public void saveVoyage(Voyage theVoyage) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theVoyage);
        currentSession.getTransaction().commit();

    }

    @Override
    public Voyage getVoyage(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Voyage theVoyage = currentSession.get(Voyage.class, theId);
        currentSession.getTransaction().commit();
        return theVoyage;
    }

    @Override
    public void deleteVoyage(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query theQuery = currentSession.createQuery("delete from Voyage where id=:voyageId");

        theQuery.setParameter("voyageId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();

    }
}
