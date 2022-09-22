package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Airplane;

import java.util.List;

public interface AirplaneService {

     List<Airplane> getAirplanes();

     void saveAirplane (Airplane theAirplane);

     Airplane getAirplane(int theId);

     void deleteAirplane(int theId);
}
