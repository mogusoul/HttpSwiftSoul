package com.mogusoul.net.service;

import com.mogusoul.net.worm.K17FictionWorm;

/**
 * Created by Administrator on 2016/7/19.
 */
public class TestService {


//    private String startUrl = "http://www.17k.com/chapter/968275/17636993.html";
    private String startUrl = "http://www.17k.com/chapter/968275/17636993.html";
//    private String stopUrl = "http://www.17k.com/chapter/968275/17905033.html";
    private String stopUrl = "http://www.17k.com/chapter/968275/18972658.html";

    private int maxNumber = 300;


    public TestService(){

    }

    public static void main(String[] args){

        TestService testService = new TestService();
        testService.start();
    }




    public void start(){

        K17FictionWorm worn = new K17FictionWorm("mingzei");

        worn.getDocument(startUrl);

        int index = 0;
        while (index < maxNumber){

            long s1 = System.currentTimeMillis();

            String next = worn.parseNext();
            String title = worn.parseTitle();

            String nextUrl = worn.getCompleteUrl(next);

            System.out.println(title);
            System.out.println(nextUrl);


            if (stopUrl.equals(nextUrl)){
                System.out.println("break");
                break;
            }
            worn.getDocument(nextUrl);

            long s2 = System.currentTimeMillis();

            if ((s2-s1) < 10000){
                try {

                    Thread.sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }




    }

}
