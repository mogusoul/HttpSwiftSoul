package com.mogusoul.net.services;

import com.mogusoul.net.aop.Action;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/22.
 */

@Service
public class TestService {

    @Action(name = "test hello")
    public String sayHello(String word) {
        return "hello " + word;
    }
}
