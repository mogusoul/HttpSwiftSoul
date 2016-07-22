package com.mogusoul.net.api;


import com.mogusoul.net.services.FunctionService;
import com.mogusoul.net.configs.ServicesConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ServiceHelperTest {


    @Test
    public void test() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testService() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class);

        FunctionService service = context.getBean(FunctionService.class);

        System.out.println(service.say("tom .."));
        System.out.println(service.say("tom .."));
        System.out.println(service.say("tom .."));

        context.close();
        assertEquals(4, 2 + 2);
    }
}
