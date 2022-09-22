package com.example.ucakbilet.dao;

import com.example.ucakbilet.entity.Airplane;

import java.util.List;

public interface AirplaneDAO {
     List<Airplane> getAirplanes();

     void saveAirplane (Airplane theAirplane);

     Airplane getAirplane(int theId);

     void deleteAirplane(int theId);
}
