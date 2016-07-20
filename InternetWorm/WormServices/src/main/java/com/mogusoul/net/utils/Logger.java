package com.mogusoul.net.utils;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Logger {

    public static final String TAG_I = "info";
    public static final String TAG_D = "debug";
    public static final String TAG_W = "warn";
    public static final String TAG_E = "error";


    public static boolean INFO = true;
    public static boolean DEBUG = true;
    public static boolean WRAN = true;
    public static boolean ERROR = true;


    public static void i(String log){
        if (INFO){
            write(TAG_I,log);
        }
    }

    public static void d(String log){
        if (DEBUG){
            write(TAG_D,log);
        }
    }

    public static void w(String log){
        if (WRAN){
            write(TAG_W,log);
        }
    }

    public static void e(String log){
        if (ERROR){
            write(TAG_E,log);
        }
    }


    public static void write(String tag, String log){
        System.out.println(tag+": "+log);
    }

}
