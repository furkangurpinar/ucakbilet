package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Airport;

import java.util.List;

public interface AirportService {

    List<Airport> getAirports();

    void saveAirport (Airport theAirport);

    Airport getAirport(int theId);

    void deleteAirport(int theId);
}
