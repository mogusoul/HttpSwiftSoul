package com.example;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/25.
 */
public class LoggerTest {



    @Test
    public void test() throws Exception {

        Logger logger = Logger.getLogger(this.getClass());

        logger.debug("debug: test");
        logger.info("info: test");
        logger.warn("warn: test");
        logger.error("error: test");
        logger.fatal("fatal: test");
        logger.trace("trace: test");

        assertEquals(4, 2 + 2);
    }

}
