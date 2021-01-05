package com.mybatis.Student.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mybatis.Student.exceptions.ResourceNotFound;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

@Service
public class StudentMongoService {
    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    MongoClient mongoClient=new MongoClient("localhost",27017);
    MongoDatabase mongoDatabase=mongoClient.getDatabase("StudentRecords");

    MongoCollection<Document> collection = mongoDatabase.getCollection("Students");


    public StudentResultDto getStudentAvgResult(String subject, String standard) {

        AggregateIterable<Document> result =collection.aggregate(Arrays.asList(
                unwind("$subjects"),
                match(and(eq("standard", standard), eq("subjects.paperName", subject))),
                group(eq("standard", "$standard"), avg("AverageMarks", "$subjects.marks"))));


        System.out.println("???????");
        System.out.println(result.first().toJson());
//        System.out.println("????");;
        if (result.first().isEmpty())
            throw new ResourceNotFound("No record found.Please input the correct values.");

        StudentResultDto studentResultDto =new StudentResultDto();
        studentResultDto.setStandard(standard);
        studentResultDto.setSubject(subject);
        studentResultDto.setAverageMarks((Double) result.first().get("AverageMarks"));

        return studentResultDto;
    }

    public List<Student> getAllStudentsFromMongo() {
        List<Student> studentListMongo=studentMongoRepository.findAll();
        return studentListMongo;
    }
}
