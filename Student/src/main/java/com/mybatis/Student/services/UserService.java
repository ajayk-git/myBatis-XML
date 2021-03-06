package com.mybatis.Student.services;

import com.mybatis.Student.entities.AppUser;
import com.mybatis.Student.entities.User;
import com.mybatis.Student.exceptions.ResourceAlreadyExist;
import com.mybatis.Student.mappers.UserMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements UserDetailsService{


    @Autowired
    UserMapper userMapper;

    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


    public List<User> getAllUsers() {

        List<User> userList=userMapper.getAllUsers();
        return userList;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userMapper.findByUserName(username);

        System.out.println("inside loadUserByUsername method");
        if (username!=null){
            return new AppUser(user);
        }
        else throw new RuntimeException();
    }


    public ResponseEntity addNewUserRecord(User user) {
        User userAlready = userMapper.findByUserName(user.getUsername());
        if (userAlready == null) {
            userMapper.insertUserRecord(user);
            return new ResponseEntity("User Added Successfully", HttpStatus.CREATED);
        }
        throw new ResourceAlreadyExist("User Already Exist.");

    }

}
