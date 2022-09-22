package com.example.ucakbilet.restController;

import com.example.ucakbilet.entity.Class;
import com.example.ucakbilet.exception.card.CardNotFoundException;
import com.example.ucakbilet.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/classes")
    public List<Class> getClasses(){
        return classService.getClasses();
    }

    @GetMapping("/classes/{classId}")
    public Class getClass(@PathVariable int classId){
        Class theClass = classService.getClass(classId);
        if(theClass== null){
            throw new CardNotFoundException("Class id not found - "+classId);
        }
        return theClass;
    }
    @PostMapping("/classes")
    public Class addClass(@RequestBody Class theClass){
        theClass.setId(0);
        classService.saveClass(theClass);
        return theClass;
    }
    @PutMapping("/classes")
    public Class updateClass(@RequestBody Class theClass){
        classService.saveClass(theClass);
        return theClass;
    }
    @DeleteMapping("/classes/{classId}")
    public String deleteClass(@PathVariable int classId){

        Class tempClass = classService.getClass(classId);

        //throw exception if null
        if(tempClass== null){
            throw new CardNotFoundException("Class id not found - "+classId);
        }
        classService.deleteClass(classId);


        return "deleted Class id -" + classId;
    }
}
