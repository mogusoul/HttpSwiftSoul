package com.mogusoul.net;

import com.mogusoul.net.utils.FileUtils;

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

    @Test
    public void testChacheFile() throws Exception {

        String fileName = "fictions/123.test";
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println(file.isDirectory());
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getAbsolutePath());

            System.out.println(file.getCanonicalFile());
            System.out.println(file.getCanonicalPath());

            System.out.println(file.getName());
            System.out.println(file.getParent());

            System.out.println(file.getPath());
            System.out.println(file.getParentFile().getAbsoluteFile());
            System.out.println(file.getParentFile().getAbsoluteFile().isDirectory());
            System.out.println(file.getParentFile().getAbsoluteFile().canWrite());
        }


        assertEquals(4, 2 + 2);
    }


    @Test
    public void testCheck() throws Exception {

        String fileName = "sourc/name/10/20/30/40";

        boolean result = FileUtils.checkFileForWrite(fileName,true);
        System.out.println("result:"+result);

        assertEquals(4, 2 + 2);
    }



    @Test
    public void testFileParent() throws Exception {

        String fileName = "sourc/name/10/20/30/40";

        File file = new File(fileName);
        while(true){
            System.out.println(file.getCanonicalPath());
            file = file.getParentFile();
            if (file == null){
                System.out.println("break");
                break;
            }
        }

        assertEquals(4, 2 + 2);
    }


    @Test
    public void testClean() throws Exception {

        String fileName = "sourc/name/10/20/30/40";

        boolean result = FileUtils.cleanFileForMkdir(new File(fileName),true);
        System.out.println("result:"+result);

//        new File(fileName).mkdirs();

        assertEquals(4, 2 + 2);
    }



}
