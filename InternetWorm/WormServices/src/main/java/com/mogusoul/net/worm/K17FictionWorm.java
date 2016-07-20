package com.mogusoul.net.worm;

import com.mogusoul.net.worm.interfaces.IFictionWorm;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2016/7/19.
 */
public class K17FictionWorm extends InternetWorm implements IFictionWorm {

    public static String HOST = "http://www.17k.com";

    private String articleName;

    public K17FictionWorm(String articleName) {
        super(articleName);
        this.articleName = articleName;
    }


    public String getCompleteUrl(String url){

        return HOST+url;
    }


    @Override
    public String parseTitle() {
        Elements name = document.select("h1[itemprop=headline]");
        return name.html();
    }

    @Override
    public String parseContent() {
        Element element = document.getElementById("chapterContentWapper");

        element.select("style").remove();
        element.select("div").remove();

        int size = element.getAllElements().size();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<size;i++){
            String node = element.childNode(i).outerHtml();
            sb.append(node);
//            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String parseTime() {
        Elements time = document.select("div[class=chapter_update_time]");
        return time.html();
    }

    @Override
    public String parseNext() {
        Elements elements = document.select("div[class=btn right]");
        elements = elements.select("ul");
        Elements e = elements.select("a:contains(下一章)");
        String next = e.get(0).attr("href");
        return next;
    }

    @Override
    public String parsePre() {
        Elements elements = document.select("div[class=btn right]");
        elements = elements.select("ul");
        Elements e = elements.select("a:contains(上一章)");
        String pre = e.get(0).attr("href");
        return pre;
    }
}
