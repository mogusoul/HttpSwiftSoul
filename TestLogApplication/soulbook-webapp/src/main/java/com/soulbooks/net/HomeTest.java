package com.soulbooks.net;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeTest extends HttpServlet {

    Logger logger =  Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.print("doGet");
        logger.info(req.getPathInfo());
        resp.getWriter().write("hello tom...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        logger.info(req.getPathInfo());
        System.out.print("doPost");
        resp.getWriter().write("hello tom...");
    }
}
