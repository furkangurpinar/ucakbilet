package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.CompanyDAO;
import com.example.ucakbilet.entity.Company;
import com.example.ucakbilet.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;
    @Override
    public List<Company> getCompanies() {
        return companyDAO.getCompanies();
    }

    @Override
    public void saveCompany(Company theCompany) {
        companyDAO.saveCompany(theCompany);

    }

    @Override
    public Company getCompany(int theId) {
        return companyDAO.getCompany(theId);
    }

    @Override
    public void deleteCompany(int theId) {
        companyDAO.deleteCompany(theId);

    }
}
