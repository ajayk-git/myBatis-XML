package com.mybatis.Student.mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMongoRepository extends MongoRepository<Subjects,String> {

    MongoClient mongoClient=new MongoClient("localhost",27017);
    MongoDatabase mongoDatabase=mongoClient.getDatabase("StudentRecords");
    MongoCollection<Document> collection = mongoDatabase.getCollection("Subjects");
}
