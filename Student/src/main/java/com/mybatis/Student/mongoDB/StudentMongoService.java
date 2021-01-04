package com.mybatis.Student.mongoDB;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.util.JSON;
import com.mybatis.Student.exceptions.ResourceNotFound;
import jdk.nashorn.api.scripting.JSObject;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;

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


    public ResponseEntity getStudentAvgResult(String subject, String standard) {

        AggregateIterable<Document> result =collection.aggregate(Arrays.asList(
                unwind("$subjects"),
                match(and(eq("standard", standard), eq("subjects.paperName", subject))),
                group(eq("standard", "$standard"), avg("AverageMarks", "$subjects.marks"))));

//        System.out.println("????");;
        if (result.first().isEmpty())
            throw new ResourceNotFound("No record found.Please input the correct values.");

        StudentResultDto studentResultDto =new StudentResultDto();
        studentResultDto.setStandard(standard);
        studentResultDto.setSubject(subject);
        studentResultDto.setAverageMarks((Double) result.first().get("AverageMarks"));

        return new ResponseEntity(studentResultDto,HttpStatus.FOUND);
    }

    public List<Student> getAllStudentsFromMongo() {
        List<Student> studentListMongo=studentMongoRepository.findAll();
        return studentListMongo;
    }
}
