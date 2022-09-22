package com.example.ucakbilet.restController;


import com.example.ucakbilet.exception.passenger.PassengerNotFoundException;
import com.example.ucakbilet.service.PassengerService;
import com.example.ucakbilet.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PassengerController {


    @Autowired //TODO uyarı veriyor neden??? araştır
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> getPassengers() {
        return passengerService.getPassengers();

    }
    @GetMapping("/passengers/{passengerId}")
    public Passenger getPassenger(@PathVariable int passengerId){
        Passenger thePassenger = passengerService.getPassenger(passengerId);
        if(thePassenger== null){
            throw new PassengerNotFoundException("passenger id not found - "+passengerId);
        }


        return thePassenger;
    }
    @PostMapping("/passengers")
    public Passenger addPassenger(@RequestBody Passenger thePassenger){
        thePassenger.setId(0);
        passengerService.savePassenger(thePassenger);
        return thePassenger;
    }
    @PutMapping("/passengers")
    public Passenger updatePassenger(@RequestBody Passenger thePassenger){

        passengerService.savePassenger(thePassenger);
        return thePassenger;
    }
    @DeleteMapping("/passengers/{passengerId}")
    public String deletePassenger(@PathVariable int passengerId){

        Passenger tempPassenger = passengerService.getPassenger(passengerId);

        if(tempPassenger== null){
            throw new PassengerNotFoundException("airplane id not found - "+passengerId);
        }

        passengerService.deletePassenger(passengerId);

        return "deleted passsenger id" +passengerId;

    }

 }
