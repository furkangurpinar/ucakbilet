package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Occupant;

import java.util.List;

public interface OccupantService {
     List<Occupant> getOccupants();

     void saveOccupant (Occupant theOccupant);

     Occupant getOccupant(int theId);

     void deleteOccupant(int theId);

}
