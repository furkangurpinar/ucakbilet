package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.OccupantDAO;
import com.example.ucakbilet.entity.Occupant;
import com.example.ucakbilet.service.OccupantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class OccupantServiceImpl implements OccupantService {

    @Autowired
    private OccupantDAO occupantDAO;



    @Override
    @Transactional
    public List<Occupant> getOccupants() {
        return occupantDAO.getOccupants();
    }

    @Override
    @Transactional
    public void saveOccupant(Occupant theOccupant) {
        occupantDAO.saveOccupant(theOccupant);

    }

    @Override
    @Transactional
    public Occupant getOccupant(int theId) {

        return occupantDAO.getOccupant(theId);
    }

    @Override
    @Transactional
    public void deleteOccupant(int theId) {

        occupantDAO.deleteOccupant(theId);

    }
}
