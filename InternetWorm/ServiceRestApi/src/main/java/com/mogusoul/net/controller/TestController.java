package com.mogusoul.net.controller;

import com.mogusoul.net.entity.Testing;
import com.soulsbooks.net.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2016/7/22.
 */
@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    TestService testService;

    @RequestMapping("/testing")
    @ResponseBody
    public Testing testing(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("==== in testing ====");

        testService.getUser(1);

        return new Testing(counter.incrementAndGet(),
                String.format(template, name));
    }
}
