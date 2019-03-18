package com.seeker;

import com.seeker.analyze.Parser;
import com.seeker.engine.SeekerEngine;
import com.seeker.network.Request;
import com.seeker.network.Response;
import com.seeker.pipline.Pipline;
import us.codecraft.xsoup.XElement;
import us.codecraft.xsoup.XElements;

import java.util.List;

/**
 * @author GregZQ
 * @create 2019-03-18 21:04
 * @des: 使用框架写爬虫
 */
public class SeekerSpider {

    public static void main(String args[]) throws Exception {
        //创建必要配置
        Spider spider = new Spider(
                new String[]{"https://cuiqingcai.com/"},
                value ->{
                    List <String> list = value.list();
                    for (String url: list) {
                        System.out.println(url);
                    }
                },
                new Parser("//div[@class='focus']//img//@src")
        );
        SeekerEngine.me(spider).run();
    }
}
