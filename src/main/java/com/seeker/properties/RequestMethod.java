package com.seeker.properties;

/**
 * @author GregZQ
 * @create 2019-03-13 21:32
 * @des: 请求方法
 */
public enum  RequestMethod {
    GET(1),
    POST(2);

    RequestMethod(Integer value){
        this.value = value;
    }
    private Integer value;

    public Integer value(){
        return this.value;
    }
}
