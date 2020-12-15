package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InterruptedNamingException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

   @Autowired
   StudentService studentService;

   @GetMapping("/all")
    List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    Student getStudentById(@PathVariable(name = "studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/add")
    ResponseEntity addNewStudentRecord(@Valid @RequestBody Student student){
        return studentService.addNewStudentRecord(student);
    }

    @PatchMapping("/update")
    Student updateStudentDetails(@RequestBody Student student  ){
      return studentService.updateStudentDetails(student);
    }
    @DeleteMapping("/{studentId}")
    List<Student>deleteStudentRecord(@PathVariable(name = "studentId") Long studentId){
        return studentService.deleteStudentRecord(studentId);
    }

}

