package com.mybatis.Student.services;

import com.mybatis.Student.entities.AppUser;
import com.mybatis.Student.entities.User;
import com.mybatis.Student.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserMapper userMapper;

    AppUser loadUserByUserName(String userName){
        User user= userMapper.findByUserName(userName);
        System.out.println(user);
        if (userName!=null){
            return new AppUser(user.getUsername(),user.getPassword(),user.getRole());
        }
        else throw new RuntimeException();
    }

    public List<User> getAllUsers() {

        List<User> userList=userMapper.getAllUsers();
        return userList;
    }
}
