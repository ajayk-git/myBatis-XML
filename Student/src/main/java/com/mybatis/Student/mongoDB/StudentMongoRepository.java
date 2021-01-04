package com.mybatis.Student.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMongoRepository extends MongoRepository<Student,String> {

    MongoClient mongoClient=new MongoClient("localhost",27017);
    MongoDatabase mongoDatabase=mongoClient.getDatabase("StudentRecords");

    MongoCollection<Document> collection = mongoDatabase.getCollection("Students");

//    public StudentResultDto getStudentAvgResult(String subject, String standard);
}
