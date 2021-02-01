package com.mybatis.Student;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.entities.User;
import com.mybatis.Student.mappers.TeacherMapper;
import com.mybatis.Student.mappers.UserMapper;
import com.mybatis.Student.mongoDB.Student;
import com.mybatis.Student.mongoDB.StudentMongoRepository;
import com.mybatis.Student.mongoDB.Subjects;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableMongoRepositories
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }


    @Component
    class DemoData implements ApplicationRunner {

        @Autowired
        public TeacherMapper teacherMapper;
        @Autowired
        public UserMapper userMapper;
        @Autowired
        StudentMongoRepository studentMongoRepository;
        @Autowired
        JdbcTemplate jdbcTemplate;

        @Override
        public void run(ApplicationArguments args) throws Exception {

            jdbcTemplate.update("drop table if exists User;");
            jdbcTemplate.update("drop table if exists Teacher;");
            jdbcTemplate.update("drop table if exists Department;");
            jdbcTemplate.update("drop table if exists Student;");
            jdbcTemplate.update("drop table if exists persistent_logins;");


			jdbcTemplate.update("create table Teacher( teacherId INT AUTO_INCREMENT PRIMARY KEY,teacherName varchar(25) NOT NULL,level varchar(25) NOT NULL,departmentId varchar(25) NOT NULL,contactNumber varchar(10) NOT NULL);");
			jdbcTemplate.update("create table User(userId INT AUTO_INCREMENT PRIMARY KEY,username varchar(25) NOT NULL,password varchar(25) NOT NULL,role varchar(25) NOT NULL);");
			jdbcTemplate.update("create table persistent_logins (username varchar(64) not null,series varchar(64) primary key,token varchar(64) not null,last_used timestamp not null);");


			jdbcTemplate.update("insert into Teacher VALUE (1,'Rakesh Verma','TGT','2','99999999');");
			jdbcTemplate.update("insert into Teacher VALUE (2,'Rajesh Yadav','PGT','1','9876543212');");
            jdbcTemplate.update("insert into Teacher VALUE (3,'Amit Yadav','PGT','1','9876543212');");

            jdbcTemplate.update("insert into User value(1,'user','password','ROLE_USER');");
			jdbcTemplate.update("insert into User value(2,'admin','password','ROLE_ADMIN');");


            Subjects subject1 = new Subjects("English", 20D);
            Subjects subject2 = new Subjects("Maths", 18D);
            List<Subjects> subjectsList1 = new ArrayList();
            subjectsList1.add(subject1);
            subjectsList1.add(subject2);
            Student student1 = new Student("601", "Amit Parashar", subjectsList1, "6");
            Student studentSaved1 = studentMongoRepository.save(student1);
            System.out.println("?????");
            System.out.println(studentSaved1.getSubjects().get(1));

            Subjects subject3 = new Subjects("English", 20D);
            Subjects subject4 = new Subjects("Maths", 18D);
            List<Subjects> subjectsList2 = new ArrayList();
            subjectsList2.add(subject3);
            subjectsList2.add(subject4);
            Student student2 = new Student("701", "Ankit Rajpal", subjectsList2, "7");
            Student studentSaved2 = studentMongoRepository.save(student2);
            System.out.println(studentSaved2);


            Subjects subject5 = new Subjects("English", 20D);
            Subjects subject6 = new Subjects("Maths", 20D);
            List<Subjects> subjectsList3 = new ArrayList();
            subjectsList3.add(subject5);
            subjectsList3.add(subject6);
            Student student3 = new Student("802", "Megha Khandelwal", subjectsList3, "8");
            Student studentSaved3 = studentMongoRepository.save(student3);
            System.out.println(studentSaved3);

			Subjects subject7=new Subjects("English",20D);
			Subjects subject8=new Subjects("Maths",18D);
			List<Subjects> subjectsList4=new ArrayList();
			subjectsList4.add(subject7);
			subjectsList4.add(subject8);
			Student student4=new Student("801","XXXXXXX",subjectsList4,"8");
			Student studentSaved4=studentMongoRepository.save(student4);
			System.out.println(studentSaved4);

        }
    }
}
