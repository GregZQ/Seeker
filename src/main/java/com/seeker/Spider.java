package com.seeker;

import com.seeker.analyze.Parser;
import com.seeker.properties.SystemProperties;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author GregZQ
 * @create 2019-03-12 21:04
 * @des: 用户需要自定义的爬虫内容
 */
public class Spider {

    private String[] urls ;
    private Parser parser;
    private Integer threadCount;
    private ThreadPoolExecutor threadPoolExecutor;

    public Spider(String [] urls,Parser parser){
        this(urls,parser, SystemProperties.THREAD_COUNT);
    }
    public Spider(String [] urls,Parser parser,Integer threadCount){
        this(urls, parser, threadCount,
                (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount));
    }
    public Spider(String []urls,Parser parser,Integer threadCount,
                  ThreadPoolExecutor executor){
        this.urls = urls;
        this.parser =parser;
        this.threadCount = threadCount;
        this.threadPoolExecutor = executor;
    }

}
