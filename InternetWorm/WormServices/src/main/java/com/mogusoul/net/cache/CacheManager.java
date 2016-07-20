package com.mogusoul.net.cache;

import com.mogusoul.net.configs.DocumentConfigs;
import com.mogusoul.net.utils.FileUtils;
import com.mogusoul.net.utils.Logger;

import org.jsoup.nodes.Document;

import java.io.File;

/**
 * Created by Administrator on 2016/7/20.
 */
public class CacheManager {

    private String cacheRootDir = DocumentConfigs.CACHE_DIR;
    private String cacheDir;
    private String cacheName;


    public CacheManager(){
        this.cacheDir = cacheRootDir;
    }

    public CacheManager(String cacheName){
        this.cacheName = cacheName;
        this.cacheDir = cacheRootDir+ File.separator+cacheName;
    }

    /**
     * saveCache.
     * @param url
     */
    public void saveCache(String url, Document doc){
        String path = FileUtils.getUrlPath(url);

        DocumentFileCache.pushCache(cacheDir+path,doc);
    }

    public void saveCache(String url, String html){
        String path = FileUtils.getUrlPath(url);

        DocumentFileCache.pushCacheIml(cacheDir+path,html);
    }

    /**
     * getCacheDocument.
     * @param url
     * @return
     */
    public Document getCacheDocument(String url){
        String path = FileUtils.getUrlPath(url);

        return DocumentFileCache.pullCache(cacheDir+path);
    }

    /**
     * getCachehtml.
     * @param url
     * @return
     */
    public String getCachehtml(String url){
        String path = FileUtils.getUrlPath(url);

        return DocumentFileCache.pullCache(cacheDir+path).html();
    }


    /**
     * exists.
     * @param url
     * @return
     */
    public boolean exists(String url){

        String path = FileUtils.getUrlPath(url);
        Logger.i(new File(cacheDir+path).getAbsolutePath());

        return new File(cacheDir+path).exists();
    }







    public String getCacheDir() {
        return cacheDir;
    }

    public void setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
    }

    public String getCacheName() {
        return cacheName;
    }

    public void setCacheName(String cacheName) {
        this.cacheName = cacheName;
    }

    public String getCacheRootDir() {
        return cacheRootDir;
    }

    public void setCacheRootDir(String cacheRootDir) {
        this.cacheRootDir = cacheRootDir;
    }
}
