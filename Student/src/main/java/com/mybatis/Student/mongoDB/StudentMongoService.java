package com.mybatis.Student.mongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMongoService {
    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;
//
//    public ResponseEntity getStudentAvgResult(String subject, String standard) {
//    }

    public List<Student> getAllStudentsFromMongo() {
        List<Student> studentListMongo=studentMongoRepository.findAll();
        return studentListMongo;
    }
}
