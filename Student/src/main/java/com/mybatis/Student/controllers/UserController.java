package com.mybatis.Student.controllers;


import com.mybatis.Student.entities.Teacher;
import com.mybatis.Student.entities.User;
import com.mybatis.Student.services.TeacherService;
import com.mybatis.Student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Secured("ROLE_USER")
    @PostMapping("/")
    ResponseEntity addNewUserRecord(@Valid @RequestBody User user){

        return userService.addNewUserRecord(user);
    }
}