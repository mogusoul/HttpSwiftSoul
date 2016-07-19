package com.mogusoul.net;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2016/7/19.
 */
public class FileTest {

    @Test
    public void test() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testFiles() throws Exception {

        File file = new File("source/test.html");
        System.out.println(file.getPath());
        System.out.println(file.exists());



        assertEquals(4, 2 + 2);
    }


}
