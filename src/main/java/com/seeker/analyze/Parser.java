package com.seeker.analyze;

import com.seeker.network.Response;
import us.codecraft.xsoup.XElements;

/**
 * @author GregZQ
 * @create 2019-03-12 21:02
 * @des: 数据解析器
 */
public class Parser {

    private String xpath;

    public Parser(String xpath){
        this.xpath = xpath;
    }

    public XElements parse(Response response){
        XElements xElements =  response.xpath(xpath);
        return xElements;
    }
}
