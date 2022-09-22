package com.example.ucakbilet.restController;


import com.example.ucakbilet.entity.Town;
import com.example.ucakbilet.exception.town.TownNotFoundException;
import com.example.ucakbilet.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TownController {

    @Autowired
    private TownService townService;

    @GetMapping("/towns")
    public List<Town> getTowns(){
        return townService.getTowns();
    }
    @GetMapping("/towns/{townsId}")
    public Town getTown(@PathVariable int townId){
        Town theTown = townService.getTown(townId);
        if(theTown== null){
            throw new TownNotFoundException("Town id not found - "+townId);
        }
        return theTown;
    }
    @PostMapping("/towns")
    public Town addTown(@RequestBody Town theTown){
        theTown.setId(0);
        townService.saveTown(theTown);
        return theTown;
    }
    @PutMapping("/towns")
    public Town updateTown(@RequestBody Town theTown){
        townService.saveTown(theTown);
        return theTown;
    }
    @DeleteMapping("/towns/{townId}")
    public String deleteTown(@PathVariable int townId){

        Town tempTown = townService.getTown(townId);

        //throw exception if null
        if(tempTown== null){
            throw new TownNotFoundException("Town id not found - "+townId);
        }
        townService.deleteTown(townId);


        return "deleted Town id -" + townId;
    }

}
