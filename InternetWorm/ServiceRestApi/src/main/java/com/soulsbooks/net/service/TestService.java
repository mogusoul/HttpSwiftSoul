package com.soulsbooks.net.service;

import com.soulsbooks.net.mapper.UserMapper;
import com.soulsbooks.net.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangjun on 2016/7/24.
 */
@Service
public class TestService {


    @Autowired
    UserMapper userMapper;

    public User getUser(int id){
        User user = userMapper.getUser(id);
        System.out.println("TestService.getUser()"+user);
        return user;
    }

}
