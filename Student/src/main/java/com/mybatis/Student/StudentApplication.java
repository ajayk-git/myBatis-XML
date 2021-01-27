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
		public   TeacherMapper teacherMapper;
		@Autowired
		public UserMapper userMapper;
		@Autowired
		StudentMongoRepository studentMongoRepository;

		@Override
		public void run(ApplicationArguments args) throws Exception {
//
//			Teacher teacher=new Teacher();
//			teacher.setDepartmentId(1L);
//			teacher.setTeacherName("TestName");
//			teacher.setContactNumber("99999999");
//			teacher.setLevel("1");
//			teacherMapper.insertTeacherRecord(teacher);
//			System.out.println("Teacher "+teacher.getTeacherName()+" added successfully");
//
//			User user=new User();
//			user.setPassword("TestPassword");
//			user.setUsername("testUser");
//			user.setRole("ROLE_USER");
//			userMapper.insertUserRecord(user);
//			System.out.println(user.getUsername());
//			System.out.println("User "+user.getUsername()+" added successfully");

			Subjects subject1=new Subjects("English",20D);
			Subjects subject2=new Subjects("Maths",18D);
			List<Subjects> subjectsList1=new ArrayList();
			subjectsList1.add(subject1);
			subjectsList1.add(subject2);
			Student student1=new Student("601","Amit Parashar",subjectsList1,"6");
			Student studentSaved1=studentMongoRepository.save(student1);
			System.out.println("?????");
			System.out.println(studentSaved1.getSubjects().get(1));

			Subjects subject3=new Subjects("English",20D);
			Subjects subject4=new Subjects("Maths",18D);
			List<Subjects> subjectsList2=new ArrayList();
			subjectsList2.add(subject3);
			subjectsList2.add(subject4);
			Student student2=new Student("701","Ankit Rajpal",subjectsList2,"7");
			Student studentSaved2=studentMongoRepository.save(student2);
			System.out.println(studentSaved2);


			Subjects subject5=new Subjects("English",20D);
			Subjects subject6=new Subjects("Maths",20D);
			List<Subjects> subjectsList3=new ArrayList();
			subjectsList3.add(subject5);
			subjectsList3.add(subject6);
			Student student3=new Student("801","Megha Khandelwal",subjectsList3,"8");
			Student studentSaved3=studentMongoRepository.save(student3);
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
