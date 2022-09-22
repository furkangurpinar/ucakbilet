package com.example.ucakbilet.service;

import com.example.ucakbilet.entity.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getPassengers();

      void savePassenger(Passenger thePassenger);

      Passenger getPassenger(int theId);

      void deletePassenger(int theId);


}
