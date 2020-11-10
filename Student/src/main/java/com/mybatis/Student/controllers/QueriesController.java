package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.Student;
import com.mybatis.Student.entities.StudentSearchDTO;
import com.mybatis.Student.entities.StudentTeacherDepartmentDto;
import com.mybatis.Student.entities.TeacherDepartmentDTO;
import com.mybatis.Student.services.QueriesService;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("3")
//   List <Student>searchStudentApi(@RequestParam(name = "StudentFirstName",required = false) String StudentFirstName,@RequestParam(name = "StudentLastName",required = false) String StudentLastName){
//        return queriesService.
//    }

    @GetMapping("student")
    List<Student> studentSearchAPI(@RequestBody StudentSearchDTO studentSearchDTO){
        List<Student> studentList=queriesService.studentSearchAPI(studentSearchDTO);
        return studentList;
    }
}
