package com.example.ucakbilet.dao;

import com.example.ucakbilet.entity.Airport;

import java.util.List;

public interface AirportDAO {
    List<Airport> getAirports();

    void saveAirport (Airport theAirport);

    Airport getAirport(int theId);

    void deleteAirport(int theId);
}
