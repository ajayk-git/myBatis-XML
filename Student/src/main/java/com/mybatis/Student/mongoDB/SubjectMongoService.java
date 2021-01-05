package com.mybatis.Student.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mybatis.Student.exceptions.ResourceNotFound;
import org.bson.BsonNull;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Arrays;

import org.bson.BsonNull;

import static com.mongodb.client.model.Accumulators.addToSet;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Projections.include;


@Service
public class SubjectMongoService {

    @Autowired
    SubjectMongoRepository subjectMongoRepository;
    //    MongoTemplate mongoTemplate;
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("StudentRecords");
    MongoCollection<Document> collection = mongoDatabase.getCollection("Subjects");


    public List<SubjectDto> getAllSubjects() {
        List<Subjects> subjectsList = subjectMongoRepository.findAll();

        List<SubjectDto> subjectDtoList = new ArrayList<>();
        subjectsList.forEach(subjects -> subjectDtoList.add(new SubjectDto(subjects.getPaperName())));
        if (subjectsList.isEmpty())
            throw new ResourceNotFound("No Subjects Found.");
        return subjectDtoList;
//        Aggregation aggregation=Aggregation.newAggregation(Aggregation.project().and("paperName").as("subject"));
//        subjectsList= (List<Subjects>) mongoTemplate.aggregate(aggregation,"Subjects",Subjects.class);
//        subjectsList.forEach(list-> System.out.println(list.getPaperName()));

//        FindIterable<Document> result = collection.aggregate(Arrays.asList(project(fields(excludeId(), include("paperName")))));


//
//        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(group(new BsonNull(), addToSet("subjects", "$paperName")), project(fields(excludeId(), include("subjects")))));
//
//        System.out.println("????");
//        System.out.println(result.first().get("subjects"));
////        subjectsList=result.first();
    }
}
