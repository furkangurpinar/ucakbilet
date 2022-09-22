package com.example.ucakbilet.dao;


import com.example.ucakbilet.entity.Route;

import java.util.List;

public interface RouteDAO {
    List<Route> getRoutes();

    void saveRoute (Route theRoute);

    Route getRoute(int theId);

    void deleteRoute(int theId);
}
