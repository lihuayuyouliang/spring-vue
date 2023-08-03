package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        if (user.getId()==null){
            return userMapper.insert(user);
        }else {
            return userMapper.update(user);
        }
    }
}
