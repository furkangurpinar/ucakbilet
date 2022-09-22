package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Voyage;

import java.util.List;

public interface VoyageService {
    List<Voyage> getVoyages();
    void saveVoyage(Voyage theVoyage);

    Voyage getVoyage(int theId);

    void deleteVoyage(int theId);
}
