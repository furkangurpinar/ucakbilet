package com.example.ucakbilet.dao.impl;

import com.example.ucakbilet.dao.CompanyDAO;
import com.example.ucakbilet.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Company> getCompanies() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query<Company> theQuery = currentSession.createQuery("from Company ", Company.class);

        //execute query and get result list
        List<Company> companies = theQuery.getResultList();
        currentSession.getTransaction().commit();


        return companies;
    }

    @Override
    public void saveCompany(Company theCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        currentSession.saveOrUpdate(theCompany);
        currentSession.getTransaction().commit();

    }

    @Override
    public Company getCompany(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();

        Company theCompany = currentSession.get(Company.class, theId);
        currentSession.getTransaction().commit();
        return theCompany;
    }

    @Override
    public void deleteCompany(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();


        Query theQuery = currentSession.createQuery("delete from Company where id=:companyId");

        theQuery.setParameter("companyId", theId);
        theQuery.executeUpdate();
        currentSession.getTransaction().commit();

    }
}
