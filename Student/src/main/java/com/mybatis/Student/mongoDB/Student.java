package com.mybatis.Student.mongoDB;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Students")
@Getter
@Setter
public class Student {

    @Autowired
    Subjects subjectObject;

    @Id
    public String studentId;
    public String studentName;
    public List<Subjects> subjects;
    String standard;

    public Student( String studentId, String studentName, List<Subjects> subjects, String standard) {
        this.subjectObject = subjectObject;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjects = subjects;
        this.standard = standard;
    }

    public Student(){}
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Subjects getSubjectObject() {
        return subjectObject;
    }

    public void setSubjectObject(Subjects subjectObject) {
        this.subjectObject = subjectObject;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

}
