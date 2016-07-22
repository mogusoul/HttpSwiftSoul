package com.mogusoul.net.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2016/7/22.
 */

@Configuration
@ComponentScan("com.mogusoul.net.controller")
@EnableAutoConfiguration
public class ControllersConfig {

}
