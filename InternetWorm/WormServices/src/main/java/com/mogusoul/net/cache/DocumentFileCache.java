package com.mogusoul.net.cache;

import com.mogusoul.net.configs.DocumentConfigs;
import com.mogusoul.net.utils.FileUtils;
import com.mogusoul.net.utils.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/19.
 */
public class DocumentFileCache {


    /**
     * pushCache.
     * @param fileName
     * @param document
     * @return
     */
    public static boolean pushCache(String fileName, Document document) {
        String html = document.html();
        return pushCacheIml(fileName,html);
    }

    /**
     * pullCache.
     * @param fileName
     * @return
     */
    public static Document pullCache(String fileName) {

        return loadCacheHtml(fileName);
    }

    /**
     * pushCacheIml.
     * @param fileName
     * @param html
     * @return
     */
    public static boolean pushCacheIml(String fileName, String html) {
        FileOutputStream out;
        if (fileName == null || html == null){
            return false;
        }

        try {
            File file = new File(fileName);
            if (file.exists() && file.isFile()){
                Logger.i("pushCacheIml: "+"file already exists... ");
                return false;
            }

            if(!FileUtils.checkFileForWrite(fileName)){
                Logger.i("pushCacheIml: "+"file exists at directory ");
                return false;
            }

            out = new FileOutputStream(fileName);
            out.write(html.getBytes(DocumentConfigs.charset));
            out.close();
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
            return false;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * loadCacheHtml.
     * @param fileName
     * @return @see Document
     */
    public static Document loadCacheHtml(String fileName) {
        Document doc = null;
        if (fileName == null){
            return null;
        }
        File htmlFile = new File(fileName);

        if (htmlFile.exists()){
            try {
                doc = Jsoup.parse(htmlFile, DocumentConfigs.charset);
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        return doc;
    }


}
