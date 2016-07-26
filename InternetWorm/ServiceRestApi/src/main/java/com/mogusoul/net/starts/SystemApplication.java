package com.mogusoul.net.starts;

import com.mogusoul.net.log.MessageService;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/7/22.
 */
public class SystemApplication {

    public static void main(String[] args){

        System.out.println("This is SystemApplication");

//        Log logger = LogFactory.getLog(SystemApplication.class);

        Logger logger = Logger.getLogger(SystemApplication.class);

        logger.debug("debug: test");
        logger.info("info: test");
        logger.warn("warn: test");
        logger.error("error: test");
        logger.fatal("fatal: test");
        logger.trace("trace: test");

        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        logger.info("Received message: " + message);


    }
}
