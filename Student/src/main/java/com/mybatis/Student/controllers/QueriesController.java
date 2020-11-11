package com.mybatis.Student.controllers;

import com.mybatis.Student.dtos.MultipleStudentSearchByIDDto;
import com.mybatis.Student.entities.Student;
import com.mybatis.Student.dtos.StudentSearchDTO;
import com.mybatis.Student.dtos.StudentTeacherDepartmentDto;
import com.mybatis.Student.dtos.TeacherDepartmentDTO;
import com.mybatis.Student.services.QueriesService;
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

    @GetMapping("students")
    List<Student> studentSearchAPI(@RequestBody StudentSearchDTO studentSearchDTO){
        List<Student> studentList=queriesService.studentSearchAPI(studentSearchDTO);
        return studentList;
    }

    @GetMapping("student/ids")
    List<Student> multipleStudentSearchAPI( @RequestBody  MultipleStudentSearchByIDDto multipleStudentSearchByIDDto){

        List<Student> studentList=queriesService.multipleStudentSearchAPI(multipleStudentSearchByIDDto);
        return studentList;
    }
}
