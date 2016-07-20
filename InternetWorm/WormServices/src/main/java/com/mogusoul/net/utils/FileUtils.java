package com.mogusoul.net.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/20.
 */
public class FileUtils {


    /**
     * checkFileForWrite.
     * @param fileName
     * @return
     */
    public static boolean checkFileForWrite(String fileName){
        return checkFileForWrite(fileName,false);
    }

    /**
     * checkFileForWrite.
     * @param fileName
     * @param force
     * @return false is the file can not use
     */
    public static boolean checkFileForWrite(String fileName, boolean force) {
        if (fileName == null) {
            return false;
        }

        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (force) {
                    Logger.d("delete directory: "+file.getAbsolutePath());
                    file.delete();
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            if (cleanFileForMkdir(file, force)){
                File parent = file.getParentFile();
                if (parent != null) parent.mkdirs();
                return true;
            } else {
                return false;
            }

        }
    }

    /**
     * cleanFileForMkdir.
     * @param file
     * @return  false is have a file and can not delete
     */
    public static boolean cleanFileForMkdir(File file, boolean force) {
        File parent = file.getParentFile();
        if (parent == null) {
            return true;
        }
        Logger.d("cleanFileForMkdir: "+parent.getAbsolutePath());
        if (parent.exists()) {
            if (parent.isDirectory()) {
                return true;
            } else {
                if (force){
                    Logger.d("delete file: "+file.getAbsolutePath());
                    parent.delete();
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return cleanFileForMkdir(parent,force);
        }
    }

    /**
     * getDirectory is get current directory.
     * @return
     */
    public static String getDirectory(){
        String directory = null;
        try {
            directory = new File(".").getCanonicalPath();
        }catch (IOException e){
            e.printStackTrace();
        }
        return directory;
    }

    /**
     * getUrlPath.
     * @param url
     * @return
     */
    public static String getUrlPath(String url){
        String path = "temp";

        try {
            URL net = new URL(url);
            path = net.getPath();
        } catch (MalformedURLException e){
            Logger.e("getUrlDirectory: "+url);
        }
        return path;
    }





}
