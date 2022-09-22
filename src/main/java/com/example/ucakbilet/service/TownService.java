package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Town;

import java.util.List;

public interface TownService {
    List<Town> getTowns();
    void saveTown(Town theTown);

    Town getTown(int theId);

    void deleteTown(int theId);
}
