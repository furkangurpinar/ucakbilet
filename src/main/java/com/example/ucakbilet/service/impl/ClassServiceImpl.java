package com.example.ucakbilet.service.impl;

import com.example.ucakbilet.dao.ClassDAO;

import com.example.ucakbilet.entity.Class;

import com.example.ucakbilet.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDAO classDAO;

    @Override
    public List<Class> getClasses() {
        return classDAO.getClasses();
    }

    @Override
    public void saveClass(Class theClass) {
        classDAO.saveClass(theClass);

    }

    @Override
    public Class getClass(int theId) {
        return classDAO.getClass(theId);
    }

    @Override
    public void deleteClass(int theId) {
        classDAO.deleteClass(theId);

    }
}
