package com.mogusoul.net.controllerx;

import com.mogusoul.net.aop.Action;
import com.mogusoul.net.aspect.MethodAspect;
import com.mogusoul.net.entity.Testing;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2016/7/22.
 */

@RestController
public class ConfigController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @Autowired
    MethodAspect methodAspect;

    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/config")
    @ResponseBody
    @Action(name = "test ConfigController")
    public Testing config(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        System.out.println("==== in config ====");

//        add();
        logger.info ("ConfigController::config()");
        logger.error("ConfigController::config()");
        logger.debug("ConfigController::config()");

        System.out.println(new File("").getAbsolutePath());

        return new Testing(counter.incrementAndGet(),
                String.format(template, name));
    }


    public void add(){
        System.out.println("==== in add ====");
        methodAspect.add();

    }
}