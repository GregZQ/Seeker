package com.seeker.network;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GregZQ
 * @create 2019-03-12 21:07
 * @des: 网页请求封装
 */
public class Request {
    private String url;//处理Url
    private String userAgent;//处理标识
    private String method;//请求方法

    private Map<String,String>  head = new HashMap<String, String>();

    public void addHeader(String headName,String value){
        head.put(headName,value);
    }

}
