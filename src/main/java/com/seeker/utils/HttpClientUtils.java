package com.seeker.utils;

import com.seeker.network.Request;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * @author GregZQ
 * @create 2019-03-13 20:19
 * @des: 发起网页请求工具
 */
public class HttpClientUtils {

    public static InputStream getHtml(Request request) throws IOException {
        //HttpClient 超时配置
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
                .setConnectionRequestTimeout(request.getConnectionRequestTimeout())
                .setConnectTimeout(request.getConnectTimeout()).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        HttpGet httpGet = new HttpGet(request.getUrl());
        Map<String,String> map = request.getHead();

        Set<String> set = map.keySet();
        for (String key: set) {
            httpGet.addHeader(key,map.get(key));
        }

        CloseableHttpResponse response = httpClient.execute(httpGet);

        InputStream in = response.getEntity().getContent();
        return in;
    }

    public static InputStream postHtml(Request request) {
        //HttpClient 超时配置
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD)
                .setConnectionRequestTimeout(request.getConnectionRequestTimeout())
                .setConnectTimeout(request.getConnectTimeout()).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();

        return null;
    }
}
