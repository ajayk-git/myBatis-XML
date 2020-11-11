package com.mybatis.Student.services;

import com.mybatis.Student.dtos.MultipleStudentSearchByIDDto;
import com.mybatis.Student.entities.Student;
import com.mybatis.Student.dtos.StudentSearchDTO;
import com.mybatis.Student.dtos.StudentTeacherDepartmentDto;
import com.mybatis.Student.dtos.TeacherDepartmentDTO;
import com.mybatis.Student.exceptions.ResourceNotFound;
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
        if (teacherDepartmentDTOList.isEmpty())
            throw new ResourceNotFound("No resource found");

        return teacherDepartmentDTOList;
    }

    public List<StudentTeacherDepartmentDto> studentTeacherSameDepartment() {
        List<StudentTeacherDepartmentDto> studentTeacherDepartmentDtoList = queriesMapper.studentTeacherSameDepartment();
        if (studentTeacherDepartmentDtoList.isEmpty())
            throw new ResourceNotFound("No resource found");

        return studentTeacherDepartmentDtoList;

    }

    public List<Student> studentSearchAPI(StudentSearchDTO studentSearchDTO) {
        List<Student> studentList = queriesMapper.studentSearchAPI(studentSearchDTO);

        if (studentList.isEmpty()) {
            throw new ResourceNotFound("No record match for input");
        }
        return studentList;
    }


    public List<Student> multipleStudentSearchAPI(MultipleStudentSearchByIDDto multipleStudentSearchByIDDto) {
        List<Student> studentList = queriesMapper.multipleStudentSearchAPI(multipleStudentSearchByIDDto);

        if (studentList.isEmpty()) {
            throw new ResourceNotFound("No record match for input");
        }
        return studentList;
    }
}
