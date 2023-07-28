// ClassController.java
package com.learner.academy.controller;

import com.learner.academy.entity.Class;
import com.learner.academy.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Class getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public Class createClass(@RequestBody Class clazz) {
        return classService.createClass(clazz);
    }

    @PutMapping("/{id}")
    public Class updateClass(@PathVariable Long id, @RequestBody Class updatedClass) {
        return classService.updateClass(id, updatedClass);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}
