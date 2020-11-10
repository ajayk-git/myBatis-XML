package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.StudentTeacherDepartmentDto;
import com.mybatis.Student.entities.TeacherDepartmentDTO;
import com.mybatis.Student.services.QueriesService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/")
public class QueriesController {

    @Autowired
    QueriesService queriesService;

    @GetMapping("1")
    List<TeacherDepartmentDTO> getTeacherAndDepartment() {

        List<TeacherDepartmentDTO> teacherDepartmentDTOList = queriesService.getTeacherAndDepartment();
        return teacherDepartmentDTOList;
    }

    @GetMapping("2")
    List<StudentTeacherDepartmentDto>getTeacherStudentSameDepartment(){
        List<StudentTeacherDepartmentDto> studentTeacherDepartmentDtos=queriesService.studentTeacherSameDepartment();
        return studentTeacherDepartmentDtos;
    }
}
