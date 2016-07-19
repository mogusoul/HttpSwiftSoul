package com.mogusoul.music.utils;

/**
 * Created by Administrator on 2016/7/11.
 */
public class CollectionsUtils {



    public static String toString(String[] collection){
        if (collection == null){
            return "null";
        }
        String collectionString = "";
        for (int i=0; i<collection.length;i++){
            collectionString+= collection[i]+":";
        }
        return collectionString;
    }

    public static String toString(int[] collection){
        if (collection == null){
            return "null";
        }
        String collectionString = "";
        for (int i=0; i<collection.length;i++){
            collectionString+= collection[i]+":";
        }
        return collectionString;
    }
}
