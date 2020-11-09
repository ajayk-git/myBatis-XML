package com.mybatis.Student.mappers;

import com.mybatis.Student.entities.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    List<Teacher> getAllTeachers();
}
