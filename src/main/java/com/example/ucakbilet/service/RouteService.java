package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Route;

import java.util.List;

public interface RouteService {
    List<Route> getRoutes();

    void saveRoute (Route theRoute);

    Route getRoute(int theId);

    void deleteRoute(int theId);
}
