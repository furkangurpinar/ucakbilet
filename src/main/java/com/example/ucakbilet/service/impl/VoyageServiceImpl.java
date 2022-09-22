package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.VoyageDAO;
import com.example.ucakbilet.entity.Voyage;
import com.example.ucakbilet.service.VoyageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {

    @Autowired
    private VoyageDAO voyageDAO;
    @Override
    public List<Voyage> getVoyages() {
        return voyageDAO.getVoyages();
    }

    @Override
    public void saveVoyage(Voyage theVoyage) {
        voyageDAO.saveVoyage(theVoyage);

    }

    @Override
    public Voyage getVoyage(int theId) {
        return voyageDAO.getVoyage(theId);
    }

    @Override
    public void deleteVoyage(int theId) {
        voyageDAO.deleteVoyage(theId);

    }
}
