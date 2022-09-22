package com.example.ucakbilet.dao;


import com.example.ucakbilet.entity.Occupant;

import java.util.List;

public interface OccupantDAO {
     List<Occupant> getOccupants();

     void saveOccupant (Occupant theOccupant);

     Occupant getOccupant(int theId);

     void deleteOccupant(int theId);


}
