package com.mybatis.Student.mongoDB;
import com.mongodb.client.*;
import com.mybatis.Student.exceptions.ResourceNotFound;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import java.util.*;
import static com.mongodb.client.model.Accumulators.avg;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.MongoCollection;

import java.util.Arrays;

@Service
public class StudentMongoService {
    @Autowired
    StudentMongoRepository studentMongoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public StudentResultDto getStudentAvgResult(String subject,String standard){

        MongoCollection<Document> collection=  mongoTemplate.getCollection("Students");
        AggregateIterable<Document> result =collection.aggregate(Arrays.asList(
                unwind("$subjects"),
                match(and(eq("standard", standard), eq("subjects.paperName", subject))),
                group(eq("standard", "$standard"), avg("AverageMarks", "$subjects.marks"))));

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
