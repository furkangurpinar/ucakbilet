package com.example.ucakbilet.dao;

import com.example.ucakbilet.entity.Passenger;

import java.util.List;

public interface PassengerDAO {
     List<Passenger> getPassengers();
     void savePassenger(Passenger thePassenger);

     Passenger getPassenger(int theId);

     void deletePassenger(int theId);

}
