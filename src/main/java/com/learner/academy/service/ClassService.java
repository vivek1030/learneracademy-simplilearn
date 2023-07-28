package com.learner.academy.service;

import com.learner.academy.entity.Class;
import com.learner.academy.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class createClass(Class clazz) {
        return classRepository.save(clazz);
    }

    public Class updateClass(Long id, Class updatedClass) {
        return classRepository.findById(id).map(clazz -> {
            clazz.setName(updatedClass.getName());
            return classRepository.save(clazz);
        }).orElse(null);
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}