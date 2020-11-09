package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping("/all")
    List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }
}
