package com.mybatis.Student.mongoDB;

import com.mybatis.Student.mongoDB.Student;
import com.mybatis.Student.mongoDB.StudentMongoService;
import com.mybatis.Student.mongoDB.StudentResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/avg")
    ResponseEntity getStudentAvgResult(@RequestParam(name = "subject") String subject,
                                    @RequestParam(name = "standard") String standard){

        return studentMongoService.getStudentAvgResult(subject,standard);

    }
}
