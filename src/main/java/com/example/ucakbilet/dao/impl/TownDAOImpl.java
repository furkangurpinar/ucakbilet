package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.TownDAO;
import com.example.ucakbilet.entity.Town;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TownDAOImpl implements TownDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Town> getTowns() {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query<Town> theQuery = currentSession.createQuery("from Town ", Town.class);

        List<Town> towns = theQuery.getResultList();

        currentSession.getTransaction().commit();
        return towns;
    }

    @Override
    public void saveTown(Town theTown) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theTown);

        currentSession.getTransaction().commit();

    }

    @Override
    public Town getTown(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Town theTown = currentSession.get(Town.class,theId);

        return theTown;
    }

    @Override
    public void deleteTown(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Town where id =:townId");

        theQuery.setParameter("townId", theId);

        theQuery.executeUpdate();

        currentSession.getTransaction().commit();

    }

}
