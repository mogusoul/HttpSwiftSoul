package com.mogusoul.net.api;

import com.mogusoul.net.log.MessageService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/25.
 */
public class LogTest {


    private MessageService messageService;

    @Before
    public void setUp(){
        messageService = new MessageService();
    }

    @Test
    public void test() throws Exception {

        Log logger = LogFactory.getLog(LogTest.class);

        logger.debug("debug: test");
        logger.info("info: test");
        logger.warn("warn: test");
        logger.error("error: test");
        logger.fatal("fatal: test");
        logger.trace("trace: test");

        assertEquals("Hello World!", messageService.getMessage());
    }

}
