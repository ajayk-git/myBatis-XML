package com.mybatis.Student.mongoDB;

import com.mybatis.Student.mongoDB.Student;
import com.mybatis.Student.mongoDB.StudentMongoService;
import com.mybatis.Student.mongoDB.StudentResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentResult")
public class StudentMongoController {

    @Autowired
    StudentMongoService studentMongoService;

    @GetMapping("/all")
    List<Student> getAllStudentsFromMongo(){
        return studentMongoService.getAllStudentsFromMongo();
    }
    @PostMapping("/add")
    Student addNewStudentRecord(@RequestBody  Student student){
        return studentMongoService.addNewStudentRecord(student);
    }
    @PostMapping("/")
    StudentResultDto getStudentAvgResult(@RequestBody AverageMarksDTO averageMarksDTO){

        return studentMongoService.getStudentAvgResult(averageMarksDTO.subject,averageMarksDTO.standard);

    }
}
