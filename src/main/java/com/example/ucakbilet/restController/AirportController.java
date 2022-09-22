package com.example.ucakbilet.restController;


import com.example.ucakbilet.entity.Airport;
import com.example.ucakbilet.exception.airport.AirportNotFoundException;
import com.example.ucakbilet.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public List<Airport> getAirports(){
        return airportService.getAirports();
    }
    @GetMapping("/airports/{airportId}")
    public Airport getAirport(@PathVariable int airportId){
        Airport theAirport = airportService.getAirport(airportId);

        if(theAirport== null){
            throw new AirportNotFoundException("airport id not found - "+airportId);
        }
                return theAirport;

    }
    @PostMapping("/airports")
    public Airport addAirport(@RequestBody Airport theAirport){
        theAirport.setId(0);
        airportService.saveAirport(theAirport);
        return theAirport;
    }
    @PutMapping("/airports")
    public Airport updateAirport(@RequestBody Airport theAirport){
        airportService.saveAirport(theAirport);
        return theAirport;
    }
    @DeleteMapping("/airports/{airportId}")
    public String deleteAirport(@PathVariable int airportId){

        Airport tempAirport = airportService.getAirport(airportId);

        //throw exception if null
        if(tempAirport== null){
            throw new AirportNotFoundException("Airport id not found - "+airportId);
        }
            airportService.deleteAirport(airportId);


        return "deleted Airport id -" + airportId;
    }


}
