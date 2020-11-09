package com.mybatis.Student.mappers;

import com.mybatis.Student.entities.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentMapper {

    List<Student> selectAllStudents();
    void insertStudentRecord(Student student);
    void deleteStudentById(Long studentId);

    Student getStudentById(Long studentId);

    void updateStudentDetails(Student student);
}
