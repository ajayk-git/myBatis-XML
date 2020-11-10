package com.mybatis.Student.services;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.entities.StudentSearchDTO;
import com.mybatis.Student.entities.StudentTeacherDepartmentDto;
import com.mybatis.Student.entities.TeacherDepartmentDTO;
import com.mybatis.Student.mappers.QueriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueriesService {

    @Autowired
    QueriesMapper queriesMapper;

    public List<TeacherDepartmentDTO> getTeacherAndDepartment() {
        List<TeacherDepartmentDTO> teacherDepartmentDTOList = queriesMapper.getTeachersANDDepartments();
        return teacherDepartmentDTOList;
    }

    public List<StudentTeacherDepartmentDto> studentTeacherSameDepartment(){
        List<StudentTeacherDepartmentDto>studentTeacherDepartmentDtoList= queriesMapper.studentTeacherSameDepartment();

        return studentTeacherDepartmentDtoList;

    }

    public List<Student>studentSearchAPI(StudentSearchDTO studentSearchDTO){
        List<Student> studentList=queriesMapper.studentSearchAPI(studentSearchDTO);
        return studentList;
    }


    }
