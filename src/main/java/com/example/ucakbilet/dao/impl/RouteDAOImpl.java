package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.RouteDAO;
import com.example.ucakbilet.entity.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDAOImpl implements RouteDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Route> getRoutes() {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query<Route> theQuery = currentSession.createQuery("from Route ", Route.class);

        List<Route> routes = theQuery.getResultList();

        currentSession.getTransaction().commit();

        return routes;
    }


    @Override
    public void saveRoute(Route theRoute) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theRoute);

        currentSession.getTransaction().commit();

    }

    @Override
    public Route getRoute(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Route theRoute = currentSession.get(Route.class, theId);

        currentSession.getTransaction().commit();

        return theRoute;
    }

    @Override
    public void deleteRoute(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Route where id =:routeId");

        theQuery.setParameter("routeId", theId);

        theQuery.executeUpdate();

        currentSession.getTransaction().commit();

    }
}
