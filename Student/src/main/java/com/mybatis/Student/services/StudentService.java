package com.mybatis.Student.services;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<Student> getAllStudents() {
        List<Student> studentList = studentMapper.selectAllStudents();
        return studentList;
    }

    public void addNewStudentRecord(Student student) {

        studentMapper.insertStudentRecord(student);
    }

    public List<Student> deleteStudentRecord(Long studentId) {
        studentMapper.deleteStudentById(studentId);
        List<Student> studentList=studentMapper.selectAllStudents();
        return studentList;
    }

    public Student getStudentById(Long studentId) {

        return studentMapper.getStudentById(studentId);

    }

    public Student updateStudentDetails( Student student) {
        studentMapper.updateStudentDetails(student);
        Student studentUpdatedDetails=studentMapper.getStudentById(student.getStudentId());
        return studentUpdatedDetails;
    }
}
