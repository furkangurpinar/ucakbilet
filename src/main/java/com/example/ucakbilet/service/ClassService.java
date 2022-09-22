package com.example.ucakbilet.service;


import com.example.ucakbilet.entity.Class;

import java.util.List;

public interface ClassService {
    List<Class> getClasses();

    void saveClass (Class theClass);

    Class getClass(int theId);

    void deleteClass(int theId);
}
