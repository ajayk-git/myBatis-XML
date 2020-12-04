package com.mybatis.Student.controllers;


import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.entities.User;
import com.mybatis.Student.services.TeacherService;
import com.mybatis.Student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}