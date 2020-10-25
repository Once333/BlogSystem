package com.young.service;

import com.young.mapper.UserMapper;
import com.young.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(String name,String password) {
        return userMapper.getUser(name,password);
    }

    public String getPassword(String name) {
        return userMapper.getPassword(name);
    }
}
