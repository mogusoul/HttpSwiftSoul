package com.mogusoul.net.application;

import com.mogusoul.net.configs.ApplicationConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/22.
 */


public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationConfig.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
//            System.out.println("beanName: "+beanName);
        }
    }

}
