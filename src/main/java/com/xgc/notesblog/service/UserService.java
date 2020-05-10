package com.xgc.notesblog.service;

import com.xgc.notesblog.Entity.User;
import com.xgc.notesblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int countUserByUsername(String username) {
        return userMapper.countUserByUsername(username);
    }

    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }
}
