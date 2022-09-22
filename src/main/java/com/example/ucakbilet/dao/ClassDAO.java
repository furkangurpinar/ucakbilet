package com.example.ucakbilet.dao;

import com.example.ucakbilet.entity.Class;

import java.util.List;

public interface ClassDAO {
    List<Class> getClasses();

    void saveClass (Class theClass);

    Class getClass(int theId);

    void deleteClass(int theId);
}
