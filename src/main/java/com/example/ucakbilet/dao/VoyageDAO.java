package com.example.ucakbilet.dao;


import com.example.ucakbilet.entity.Voyage;

import java.util.List;

public interface VoyageDAO {

    List<Voyage> getVoyages();
    void saveVoyage(Voyage theVoyage);

    Voyage getVoyage(int theId);

    void deleteVoyage(int theId);
}
