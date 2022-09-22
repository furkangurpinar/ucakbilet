package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();

    void saveCompany (Company theCompany);

    Company getCompany(int theId);

    void deleteCompany(int theId);
}
