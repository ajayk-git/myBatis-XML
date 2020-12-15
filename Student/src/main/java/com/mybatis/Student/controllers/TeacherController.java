package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }


    @DeleteMapping("/{teacherId}")
    List<Teacher> deleteTeacherRecord(@PathVariable(name = "teacherId") Long teacherId) {
        System.out.println("inside delete teacher method");

        return teacherService.deleteTeacherRecord(teacherId);
    }

    @PutMapping("/{teacherId}")
    Teacher updateTeacherDetails(@PathVariable(name = "teacherId") Long teacherId,@RequestBody Teacher teacher) {
        System.out.println("inside update teacher method");

        return teacherService.updateTeacherDetails(teacherId ,teacher);
    }


    @GetMapping("/{teacherId}")
    Teacher getTeacherById(@PathVariable(name = "teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping("/")
    ResponseEntity addNewTeacherRecord(@Valid @RequestBody Teacher teacher){

        return teacherService.addNewTeacherRecord(teacher);
    }

}