package com.seeker;

import com.seeker.network.Response;
import com.seeker.properties.UserAgent;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import us.codecraft.xsoup.XElements;

import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * @author GregZQ
 * @create 2019-03-18 21:02
 * @des:
 */
public class SimpleSpider {
    public static void main(String args[]) throws InterruptedException, IOException {
        //HttpClient 超时配置
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.STANDARD)
                .setConnectionRequestTimeout(50000)
                .setConnectTimeout(50000).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        System.out.println("开始抓取图片");

        String url = "https://cuiqingcai.com/";

        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("User-Agent", UserAgent.GOOGLE.value());
        httpGet.addHeader("Accept", "text/html");
        httpGet.addHeader("Accept-Charset", "utf-8");
        httpGet.addHeader("Accept-Encoding", "gzip");
        httpGet.addHeader("Accept-Language", "en-US,en");
        Thread.sleep(500);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        InputStream in = response.getEntity().getContent();


        Response seekerResponse = new Response(in);

        //解析器解析
        XElements xElements = seekerResponse.xpath("//div[@class='focus']//img//@src");

        //管道处理
        List<String> list = xElements.list();

        for (String value : list) {

            System.out.println(value);
            HttpGet h = new HttpGet(value);
            h.addHeader("User-Agent", UserAgent.GOOGLE.value());
            Thread.sleep(500);
            CloseableHttpResponse r = httpClient.execute(h);
            InputStream stream = r.getEntity().getContent();



            File file = new File("C:\\Users\\e550c\\Desktop\\工具\\小飞机\\"+ new Random().nextInt()+".jpg");
            OutputStream os = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            while(true) {
                int readed = stream.read(buff);
                if(readed == -1) {
                    break;
                }
                byte[] temp = new byte[readed];
                System.arraycopy(buff, 0, temp, 0, readed);
                //写入文件
                os.write(temp);
            }
            os.close();
            stream.close();
        }
    }
}
