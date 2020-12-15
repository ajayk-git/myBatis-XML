package com.mybatis.Student.services;

import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.mappers.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    @Autowired
    TeacherMapper teacherMapper;


    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = teacherMapper.getAllTeachers();
        return teacherList;
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherMapper.getTeacherById(teacherId);
    }

    public List<Teacher> deleteTeacherRecord(Long teacherId) {


        System.out.println("inside delete teacher method");
        teacherMapper.deleteTeacherById(teacherId);
        List<Teacher> teacherList = teacherMapper.getAllTeachers();
        return teacherList;
    }

    public Teacher updateTeacherDetails(Long teacherId, Teacher teacher) {
        Teacher teacherToUpdate = teacherMapper.getTeacherById(teacherId);
        System.out.println("inside Update teacher method");
        teacherToUpdate.setTeacherId(teacherId);
        teacherToUpdate.setTeacherName(teacher.getTeacherName());
        teacherToUpdate.setLevel(teacher.getLevel());
        teacherToUpdate.setContactNumber(teacher.getContactNumber());
        teacherToUpdate.setDepartmentId(teacher.getDepartmentId());

        teacherMapper.updateTeacherDetails(teacherToUpdate);
        Teacher teacherUpdatedDetails = teacherMapper.getTeacherById(teacher.getTeacherId());
        return teacherUpdatedDetails;
    }


    public ResponseEntity addNewTeacherRecord(Teacher teacher) {
        teacherMapper.insertTeacherRecord(teacher);
        return new ResponseEntity("Teacher Added Successfully", HttpStatus.CREATED);
    }
}
