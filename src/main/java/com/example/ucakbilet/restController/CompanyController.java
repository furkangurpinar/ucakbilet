package com.example.ucakbilet.restController;

import com.example.ucakbilet.entity.Company;
import com.example.ucakbilet.exception.company.CompanyNotFoundException;
import com.example.ucakbilet.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }
    @GetMapping("/companies/{companyId}")
    public Company getCompany(@PathVariable int companyId){
        Company theCompany = companyService.getCompany(companyId);
        if(theCompany== null){
            throw new CompanyNotFoundException("Company id not found - "+companyId);
        }
        return theCompany;
    }
    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company theCompany){
        theCompany.setId(0);
        companyService.saveCompany(theCompany);
        return theCompany;
    }
    @PutMapping("/companies")
    public Company updateCompany(@RequestBody Company theCompany){
        companyService.saveCompany(theCompany);
        return theCompany;
    }
    @DeleteMapping("/companies/{companyId}")
    public String deleteCompany(@PathVariable int companyId){

        Company tempCompany = companyService.getCompany(companyId);

        //throw exception if null
        if(tempCompany== null){
            throw new CompanyNotFoundException("Company id not found - "+companyId);
        }
        companyService.deleteCompany(companyId);


        return "deleted Company id -" + companyId;
    }
}
