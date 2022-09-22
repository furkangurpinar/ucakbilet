package com.example.ucakbilet.dao;


import com.example.ucakbilet.entity.Company;

import java.util.List;

public interface CompanyDAO {
    List<Company> getCompanies();

    void saveCompany (Company theCompany);

    Company getCompany(int theId);

    void deleteCompany(int theId);
}
