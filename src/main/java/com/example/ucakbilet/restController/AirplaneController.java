package com.example.ucakbilet.restController;

import com.example.ucakbilet.entity.Airplane;


import com.example.ucakbilet.exception.airplane.AirplaneNotFoundException;
import com.example.ucakbilet.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping("/airplanes")
    public List<Airplane> getAirplanes(){
        return airplaneService.getAirplanes();
    }
    @GetMapping("/airplanes/{airplaneId}")
    public Airplane getAirplane(@PathVariable int airplaneId){
        Airplane theAirplane = airplaneService.getAirplane(airplaneId);
        if(theAirplane== null){
            throw new AirplaneNotFoundException("Airplane id not found - "+airplaneId);
        }
        return theAirplane;
    }
    @PostMapping("/airplanes")
    public Airplane addAirplane(@RequestBody Airplane theAirplane){
        theAirplane.setId(0);
        airplaneService.saveAirplane(theAirplane);
        return theAirplane;
    }
    @PutMapping("/airplanes")
    public Airplane updateAirplane(@RequestBody Airplane theAirplane){
        airplaneService.saveAirplane(theAirplane);
        return theAirplane;
    }
    @DeleteMapping("/airplanes/{airplaneId}")
    public String deleteAirplane(@PathVariable int airplaneId){

        Airplane tempAirplane = airplaneService.getAirplane(airplaneId);

        //throw exception if null
        if(tempAirplane== null){
            throw new AirplaneNotFoundException("airplane id not found - "+airplaneId);
        }
        airplaneService.deleteAirplane(airplaneId);


        return "deleted airplane id -" + airplaneId;
    }





}
