package com.example.ucakbilet.restController;



import com.example.ucakbilet.entity.Voyage;
import com.example.ucakbilet.exception.voyage.VoyageNotFoundException;
import com.example.ucakbilet.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping("/voyages")
    public List<Voyage> getVoyages(){
        return voyageService.getVoyages();
    }
    @GetMapping("/voyages/{voyageId}")
    public Voyage getVoyage(@PathVariable int voyageId){
        Voyage theVoyage = voyageService.getVoyage(voyageId);
        if(theVoyage== null){
            throw new VoyageNotFoundException("Voyage id not found - "+voyageId);
        }
        return theVoyage;
    }

    @PostMapping("/voyages")
    public Voyage addVoyage(@RequestBody Voyage theVoyage){
        theVoyage.setId(0);
        voyageService.saveVoyage(theVoyage);
        return theVoyage;
    }
    @PutMapping("/voyages")
    public Voyage updateVoyage(@RequestBody Voyage theVoyage){
        voyageService.saveVoyage(theVoyage);
        return theVoyage;
    }
    @DeleteMapping("/voyages/{voyageId}")
    public String deleteVoyage(@PathVariable int voyageId){

        Voyage tempVoyage = voyageService.getVoyage(voyageId);

        //throw exception if null
        if(tempVoyage== null){
            throw new VoyageNotFoundException("Voyage id not found - "+voyageId);
        }
        voyageService.deleteVoyage(voyageId);


        return "deleted Voyage id -" + tempVoyage;
    }
}
