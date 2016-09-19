package com.ben.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Created by Ben on 9/12/2016.
 */
public class JsoupTest {

    @Test
    public void test1() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.gxyxzb.gov.cn/guawang_sys/guawang_tables.asp?page=6&guawangid=FCK16514920160625t").get();
            System.out.println(doc);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("exception");
        }
    }

    @Test
    public void test2() {
        String a = (new java.lang.String(new byte[]{111,114,103,46,97,112,97,99,104,101,46,99,111,109,109,111,110,115,46,105,111,46,73,79,85,116,105,108,115}));
        System.out.println(a);
    }
}
