package com.mogusoul.net.worm;

import com.mogusoul.net.worm.interfaces.InetWorm;

import org.jsoup.nodes.Document;

/**
 * Created by Administrator on 2016/7/19.
 */
public class BaseInternetWorm implements InetWorm {

    @Override
    public Document getDocument(String url) {
        return null;
    }
}
