package com.example.ucakbilet.restController;


import com.example.ucakbilet.entity.Route;
import com.example.ucakbilet.exception.route.RouteNotFoundException;
import com.example.ucakbilet.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController {

    @Autowired
    private RouteService routeService;
    @GetMapping("/routes")
    public List<Route> getAirplanes(){
        return routeService.getRoutes();
    }
    @GetMapping("/routes/{routeId}")
    public Route getRoute(@PathVariable int routeId){
        Route theRoute = routeService.getRoute(routeId);
        if(theRoute== null){
            throw new RouteNotFoundException("Route id not found - "+routeId);
        }
        return theRoute;
    }
    @PostMapping("/routes")
    public Route addRoute(@RequestBody Route theRoute){
        theRoute.setId(0);
        routeService.saveRoute(theRoute);
        return theRoute;
    }
    @PutMapping("/routes")
    public Route updateRoute(@RequestBody Route theRoute){
        routeService.saveRoute(theRoute);
        return theRoute;
    }
    @DeleteMapping("/routes/{routeId}")
    public String deleteRoute(@PathVariable int routeId){

        Route tempRoute = routeService.getRoute(routeId);

        //throw exception if null
        if(tempRoute== null){
            throw new RouteNotFoundException("Route id not found - "+routeId);
        }
        routeService.deleteRoute(routeId);


        return "deleted Route id -" + routeId;
    }
}
