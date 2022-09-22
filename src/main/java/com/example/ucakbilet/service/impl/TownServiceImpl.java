package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.TownDAO;
import com.example.ucakbilet.entity.Town;
import com.example.ucakbilet.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownDAO townDAO;
    @Override
    public List<Town> getTowns() {
        return townDAO.getTowns();
    }

    @Override
    public void saveTown(Town theTown) {
        townDAO.saveTown(theTown);

    }

    @Override
    public Town getTown(int theId) {
        return townDAO.getTown(theId);
    }

    @Override
    public void deleteTown(int theId) {
        townDAO.getTown(theId);

    }
}
