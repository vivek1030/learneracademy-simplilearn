package com.learner.academy.controller;

import com.learner.academy.entity.Teacher;
import com.learner.academy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        return teacherService.updateTeacher(id, updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}