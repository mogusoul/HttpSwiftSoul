package com.mogusoul.net.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/22.
 */
@Service
public class FunctionService {

    @Autowired
    TestService testService;

    public String say(String word){
        return testService.sayHello(word);
    }

}
