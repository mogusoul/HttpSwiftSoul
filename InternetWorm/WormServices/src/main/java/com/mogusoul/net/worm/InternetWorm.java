package com.mogusoul.net.worm;

import com.mogusoul.net.cache.CacheManager;
import com.mogusoul.net.service.HtmlDownloadService;
import com.mogusoul.net.worm.interfaces.InetWorm;

import org.jsoup.nodes.Document;

/**
 * Created by Administrator on 2016/7/19.
 */
public class InternetWorm implements InetWorm {

    protected CacheManager cacheManager;
    protected HtmlDownloadService htmlService;

    protected String cacheName;
    protected Document document;

    public InternetWorm(String cacheName){
        this.cacheName = cacheName;
        cacheManager = new CacheManager(cacheName);
        htmlService = new HtmlDownloadService();
    }

    @Override
    public Document getDocument(String url) {

        if (cacheManager.exists(url)){
            document =  cacheManager.getCacheDocument(url);
        } else {
            document = htmlService.download(url);
            cacheManager.saveCache(url,document);
        }
        return document;
    }
}
