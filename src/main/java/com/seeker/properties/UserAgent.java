package com.seeker.properties;

/**
 * @author GregZQ
 * @create 2019-03-12 21:46
 * @des: 浏览器标识
 */
public enum  UserAgent {

    GOOGLE("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
    UserAgent(String value){
        this.value=value;
    }

    private String value;
    public String value(){
        return this.value;
    }
}
