package com.mogusoul.net;

import com.mogusoul.net.service.HtmlDownloadService;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/19.
 */
public class WormServiceTest {


    private String url = "http://www.17k.com/chapter/968275/18985930.html";

    @Test
    public void test() throws Exception {

        System.out.print(new String("而诞生过华为哦".getBytes("gbk")));
        assertEquals(4, 2 + 2);
    }




    @Test
    public void testDownload() throws Exception {


        HtmlDownloadService htmlService = new HtmlDownloadService();

        Document doc = htmlService.download(url);
        if (doc == null){
            System.out.println("doc is null.");
            return;
        }

//        String content = doc.select("div[id=chapterContentWapper]").html();
        String content;
        Element element = doc.getElementById("chapterContentWapper");

//        String style = element.select("style").html();
//        System.out.println("content:"+style);
        element.select("style").remove();
        element.select("div").remove();
//        element.select("<").remove();
        System.out.println(element.getAllElements().size());

        int size = element.getAllElements().size();
//        for (int i=0;i<size;i++){
//            String node = element.childNode(i).outerHtml();
//            System.out.println("id="+i+":"+node);
//        }



//        Elements elements = doc.select("div[class=btn right]");
//        elements = elements.select("ul");
//
//        Elements e = elements.select("a:contains(下一章)");
//        String s1 = e.get(0).attr("href");
//        System.out.println(e.get(0));
//
//
//        System.out.println(s1+"\n");
//
//        System.out.println("elements:"+elements.size());
//        System.out.println("content:\n"+elements.html());



        Elements name = doc.select("h1[itemprop=headline]");
        Elements time = doc.select("div[class=chapter_update_time]");

        System.out.println(name.html());
        System.out.println(time.html());

//        System.out.println("content:\n"+element.html());
//        System.out.println("content:"+doc.html());

        assertEquals(4, 2 + 2);
    }
}
