package com.mybatis.Student.mappers;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.entities.StudentSearchDTO;
import com.mybatis.Student.entities.StudentTeacherDepartmentDto;
import com.mybatis.Student.entities.TeacherDepartmentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueriesMapper {



    List<TeacherDepartmentDTO> getTeachersANDDepartments();
    List<StudentTeacherDepartmentDto>studentTeacherSameDepartment();
    List<Student>studentSearchAPI(StudentSearchDTO studentSearchDTO);
}
