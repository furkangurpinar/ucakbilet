package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.ClassDAO;
import com.example.ucakbilet.entity.Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassDAOImpl implements ClassDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Class> getClasses() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query<Class> theQuery =currentSession.createQuery("from Class ",Class.class);
        List<Class> classes =theQuery.getResultList();
        currentSession.getTransaction().commit();


        return classes;
    }

    @Override
    public void saveClass(Class theClass) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(theClass);
        currentSession.getTransaction().commit();

    }

    @Override
    public Class getClass(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Class theClass = currentSession.get(Class.class,theId);
        currentSession.getTransaction().commit();

        return theClass;
    }

    @Override
    public void deleteClass(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Query theQuery = currentSession.createQuery("delete from Class where id=:classId");
        theQuery.setParameter("classId",theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();


    }
}
