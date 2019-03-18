package com.seeker.network;

import com.seeker.properties.RequestMethod;
import com.seeker.properties.SystemProperties;
import com.seeker.properties.UserAgent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GregZQ
 * @create 2019-03-12 21:07
 * @des: 网页请求封装
 */
public class Request {
    private String url;//处理Url
    private Integer method;//请求方法
    private Integer connectTimeout;//连接超时时间
    private Integer connectionRequestTimeout;//请求超时时间
    private Map<String,String>  head = new HashMap<>();//请求头

    private Request(String url){
        this.url = url;
    }
    public static Request newInstance(){
        return newInstance(null);
    }
    public static Request newInstance(String url){
        Request request = new Request(url);
        request.setUserAgent(UserAgent.GOOGLE.value());
        request.setMethod(RequestMethod.GET.value());
        request.setConnectTimeout(SystemProperties.connectTimeout);
        request.setConnectionRequestTimeout(SystemProperties.connectionRequestTimeout);
        return request;
    }

    public void addHeader(String headName,String value){
        head.put(headName,value);
    }

    public void setUrl(String url){
        this.url = url;
    }
    //设置请求超时时间
    public void setConnectTimeout(Integer connectTimeout){
        this.connectTimeout = connectTimeout;
    }
    public void setConnectionRequestTimeout(Integer connectionRequestTimeout){
        this.connectionRequestTimeout = connectionRequestTimeout;
    }
    public void setMethod(Integer value){
        this.method = value;
    }
    public void setUserAgent(String userAgent){
        this.addHeader("User-Agent",userAgent);
    }
    public void  setHead(Map<String,String>map){
        this.head = map;
    }

    public Integer getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getMethod() {
        return method;
    }

    public Map<String, String> getHead() {
        return head;
    }

    public String getUrl() {
        return url;
    }

    public String getUserAgent() {
        return this.head.get("User-Agent");
    }
}
