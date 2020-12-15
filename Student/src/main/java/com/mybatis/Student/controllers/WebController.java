package com.mybatis.Student.controllers;

import com.mybatis.Student.entities.User;
import com.mybatis.Student.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WebController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/")
    public String index(Principal principal) {
        User user = userMapper.findByUserName(principal.getName());

        if (user.getRole().equalsIgnoreCase("Admin"))
            return "index";
        else return "indexUser";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }


}
