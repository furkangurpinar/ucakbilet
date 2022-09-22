package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.AirplaneDAO;
import com.example.ucakbilet.entity.Airplane;
import com.example.ucakbilet.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneDAO airplaneDAO;

    @Autowired
    public AirplaneServiceImpl(AirplaneDAO airplaneDAO) {
        this.airplaneDAO = airplaneDAO;
    }

    @Override
    @Transactional
    public List<Airplane> getAirplanes() {
        return airplaneDAO.getAirplanes();
    }

    @Override
    @Transactional
    public void saveAirplane(Airplane theAirplane) {
        airplaneDAO.saveAirplane(theAirplane);

    }

    @Override
    @Transactional
    public Airplane getAirplane(int theId) {
        return airplaneDAO.getAirplane(theId);
    }

    @Override
    @Transactional
    public void deleteAirplane(int theId) {
        airplaneDAO.deleteAirplane(theId);

    }
}
