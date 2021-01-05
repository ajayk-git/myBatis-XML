package com.mybatis.Student.mongoDB;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectMongoController {

    @Autowired
    SubjectMongoService subjectMongoService;
    @GetMapping("/")
    List<SubjectDto> getAllSubjects(){
       return subjectMongoService.getAllSubjects();
    }
}
