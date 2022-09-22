package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.RouteDAO;
import com.example.ucakbilet.entity.Route;
import com.example.ucakbilet.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDAO routeDAO;
    @Override
    public List<Route> getRoutes() {
        return routeDAO.getRoutes();
    }

    @Override
    public void saveRoute(Route theRoute) {
        routeDAO.saveRoute(theRoute);

    }

    @Override
    public Route getRoute(int theId) {
        return routeDAO.getRoute(theId);
    }

    @Override
    public void deleteRoute(int theId) {
        routeDAO.deleteRoute(theId);

    }
}
