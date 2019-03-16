package com.seeker.properties;

/**
 * @author GregZQ
 * @create 2019-03-12 21:46
 * @des: 浏览器标识
 */
public enum  UserAgent {

    GOOGLE("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
    UserAgent(String value){
        this.value=value;
    }

    private String value;
    public String value(){
        return this.value;
    }
}
