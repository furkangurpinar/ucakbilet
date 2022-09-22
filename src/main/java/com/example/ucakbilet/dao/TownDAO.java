package com.example.ucakbilet.dao;


import com.example.ucakbilet.entity.Town;

import java.util.List;

public interface TownDAO {
    List<Town> getTowns();
    void saveTown(Town theTown);

    Town getTown(int theId);

    void deleteTown(int theId);
}
