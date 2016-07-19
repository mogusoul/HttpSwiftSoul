package com.mogusoul.net.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;

/**
 * Created by Administrator on 2016/7/19.
 */
public class HtmlDownloadService {


    public static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1";

    public static int TIME_OUT = 20000;


    private String header;
    private String ua;
    private String param;

    public HtmlDownloadService(){

    }


    public Document download(String url){
        Document doc = null;
        try{

//             doc = Jsoup
//                    .connect(url)
//                    .userAgent(USER_AGENT)
//                    .timeout(TIME_OUT)
//                    .cookie("name","worm")
//                    .header("test","ant")
//                    .get();

            doc = Jsoup.parse(new File("source/test.html"),"utf-8");

        }catch (Exception e){
            e.printStackTrace();
        }
       return doc;
    }






}
