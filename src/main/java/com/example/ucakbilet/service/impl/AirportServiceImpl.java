package com.example.ucakbilet.service.impl;


import com.example.ucakbilet.dao.AirportDAO;
import com.example.ucakbilet.entity.Airport;
import com.example.ucakbilet.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportDAO airportDAO;


    @Override
    @Transactional
    public List<Airport> getAirports() {
        return airportDAO.getAirports();
    }

    @Override
    @Transactional
    public void saveAirport(Airport theAirport) {
        airportDAO.saveAirport(theAirport);

    }

    @Override
    @Transactional
    public Airport getAirport(int theId) {
        return airportDAO.getAirport(theId);
    }

    @Override
    @Transactional
    public void deleteAirport(int theId) {
        airportDAO.deleteAirport(theId);

    }
}
