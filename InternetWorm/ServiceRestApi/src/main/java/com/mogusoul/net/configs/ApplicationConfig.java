package com.mogusoul.net.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2016/7/22.
 */

@Configuration
//@ComponentScan("com.mogusoul.net.controller")
@ComponentScan({
        "com.mogusoul.net.aop",
        "com.mogusoul.net.aspect",
        "com.mogusoul.net.controller",
        "com.mogusoul.net.controllerx"})

@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class ApplicationConfig {


    @Bean
    public void dataSource() {

    }

}
