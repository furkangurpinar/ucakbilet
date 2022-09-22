package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.PassengerDAO;
import com.example.ucakbilet.service.PassengerService;
import com.example.ucakbilet.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDAO passengerDAO;

    @Override
    @Transactional
    public List<Passenger> getPassengers() {
        return passengerDAO.getPassengers();
    }

    @Override
    @Transactional
    public void savePassenger(Passenger thePassenger) {
        passengerDAO.savePassenger(thePassenger);

    }

    @Override
    @Transactional
    public Passenger getPassenger(int theId) {
        return passengerDAO.getPassenger(theId);
    }

    @Override
    @Transactional
    public void deletePassenger(int theId) {
        passengerDAO.deletePassenger(theId);

    }
}
