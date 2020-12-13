package com.mybatis.Student.mappers;

import com.mybatis.Student.entities.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    User findByUserName(String userName);
    List<User> getAllUsers();

     void insertUserRecord(User user);
}
