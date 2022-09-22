package com.example.ucakbilet.restController;

import com.example.ucakbilet.entity.Occupant;
import com.example.ucakbilet.exception.occupant.OccupantNotFoundException;
import com.example.ucakbilet.service.OccupantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OccupantController {
    //autowire the OccupantService

    @Autowired
    private OccupantService occupantService;

    //add mapping for get/ occupants

    @GetMapping("/occupants")
    public List<Occupant> getOccupants(){
        return occupantService.getOccupants();
    }

    //add mapping for get/customers{customerId}
    @GetMapping("/occupants/{occupantId}")
    public Occupant getOccupant(@PathVariable int occupantId){
        Occupant theOccupant = occupantService.getOccupant(occupantId);
        if(theOccupant== null){
            throw new OccupantNotFoundException("occupant id not found - "+occupantId);
        }
        return theOccupant;
    }

    // add mapping for post/occupants - add new occupant
    @PostMapping("/occupants")
    public Occupant addOccupant(@RequestBody Occupant theOccupant){
        theOccupant.setId(0);
        occupantService.saveOccupant(theOccupant);
        return theOccupant;
    }

    // add mapping for put/occupants - update existing occupant

    @PutMapping("/occupants")
    public Occupant updateOccupant(@RequestBody Occupant theOccupant){
        occupantService.saveOccupant(theOccupant);
        return theOccupant;
    }

    // add mapping for delete /occupants/{occupantId} -delete occupant

    @DeleteMapping("/occupants/{occupantId}")
    public String deleteOccupant(@PathVariable int occupantId){

        Occupant tempOccupant = occupantService.getOccupant(occupantId);

        //throw exception if null
        if(tempOccupant== null){
            throw new OccupantNotFoundException("occupant id not found - "+occupantId);
        }
        occupantService.deleteOccupant(occupantId);

        return "deleted occupant id -" + occupantId;
    }



}
