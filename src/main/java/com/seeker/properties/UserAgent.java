package com.seeker.properties;

/**
 * @author GregZQ
 * @create 2019-03-12 21:46
 * @des: 浏览器标识
 */
public enum  UserAgent {

    GOOGLE("谷歌浏览器");
    UserAgent(String value){
        this.value=value;
    }

    private String value;
    public String value(){
        return this.value;
    }
}
