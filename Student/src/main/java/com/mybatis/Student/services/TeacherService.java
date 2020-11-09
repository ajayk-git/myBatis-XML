package com.mybatis.Student.services;

import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.mappers.StudentMapper;
import com.mybatis.Student.mappers.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    @Autowired
    TeacherMapper teacherMapper;


    public List<Teacher> getAllTeachers(){
        List<Teacher> teacherList=teacherMapper.getAllTeachers();
        return teacherList;
    }
}
