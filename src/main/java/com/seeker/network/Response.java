package com.seeker.network;

import org.jsoup.Jsoup;
import us.codecraft.xsoup.XElements;
import us.codecraft.xsoup.Xsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * @author GregZQ
 * @create 2019-03-12 21:07
 * @des: 相应他
 */
public class Response {

    private InputStream    bodyStream;
    private String bodyString;

    public Response(InputStream inputStream) {
        this.bodyStream = inputStream;
    }

    @Override
    public String toString() {
       if (Objects.isNull(bodyString)){
           StringBuilder html = new StringBuilder();
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bodyStream));
            String tmp;
           try {
               while ((tmp = bufferedReader.readLine())!=null){
                   html.append(tmp).append("\n");
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
           this.bodyString = bodyString;
       }
       return bodyString;
    }

    public XElements xpath(String xpath){
        return Xsoup.compile(xpath).evaluate(Jsoup.parse(this.toString()));
    }
}
