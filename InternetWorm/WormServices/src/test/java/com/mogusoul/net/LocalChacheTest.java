package com.mogusoul.net;

import com.mogusoul.net.cache.CacheManager;
import com.mogusoul.net.cache.DocumentFileCache;
import com.mogusoul.net.service.HtmlDownloadService;
import com.mogusoul.net.utils.FileUtils;
import com.mogusoul.net.utils.Logger;
import com.mogusoul.net.utils.MD5;

import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/20.
 */
public class LocalChacheTest {

    private String url = "http://www.17k.com/chapter/968275/18985930.html";
    private String url1 = "http://www.17k.com/chapter/968275/18985931.html";

    @Test
    public void test() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testManager() throws Exception {


        CacheManager manager = new CacheManager("mingzei");
        HtmlDownloadService htmlService = new HtmlDownloadService();


//        Document doc = htmlService.download(url);
        Document doc =manager.getCacheDocument(url);
        manager.saveCache(url1,doc);


        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMD5() throws Exception {
        System.out.println("LocalChacheTest::testMD5 --->>");

        String decode = "http://www.17k.com/chapter/968275/18985930.html";

        String encode1 = "E02A3B7E288DCB886C30A2E7767F9968";
        String encode2 = "11A31975A6BC4581F06E7E97CE94CA84";
        String encode3 = "72B478FD9B52F7E56EFDF381784435CE";

        String code1 = MD5.getMessageDigest(decode.getBytes());
        String code2 = MD5.getMessageDigest(code1.getBytes());
        String code3 = MD5.getMessageDigest(code2.getBytes());

        System.out.println("code1: "+code1);
        System.out.println("code2: "+code2);
        System.out.println("code3: "+code3);

        assertEquals(encode1, code1);
        assertEquals(encode2, code2);
        assertEquals(encode3, code3);
    }


    @Test
    public void testFileCache() throws Exception {
        System.out.println("LocalChacheTest::testFileCache --->>");

        HtmlDownloadService htmlService = new HtmlDownloadService();
        Document doc = htmlService.download(url);


//        DocumentFileCache.pushCacheIml("fictions/"+ MD5.getMessageDigest(url.getBytes())+".html",doc.html());
        DocumentFileCache.pushCacheIml("fictions"+ FileUtils.getUrlPath(url),doc.html());

        assertEquals(4, 2 + 2);
    }
    @Test
    public void testUrl() throws Exception {

        URL h = new URL(url);

        Logger.i(h.getProtocol());
        Logger.i(h.getHost());
        Logger.i(h.getFile());
        Logger.i(h.getPath());
        Logger.i(h.getAuthority());
        Logger.i(h.getRef());


        assertEquals(4, 2 + 2);
    }

}
