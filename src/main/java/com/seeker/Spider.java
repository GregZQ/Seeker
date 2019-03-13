package com.seeker;

import com.seeker.analyze.Parser;
import com.seeker.pipline.Pipline;
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
    private Pipline pipline;
    private Integer threadCount;
    private ThreadPoolExecutor threadPoolExecutor;

    public Spider(String [] urls, Pipline pipline, Parser parser){
        this(urls,pipline,parser, SystemProperties.THREAD_COUNT);
    }
    public Spider(String [] urls,Pipline pipline,Parser parser,Integer threadCount){
        this(urls,pipline,parser, threadCount,
                (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount));
    }
    public Spider(String []urls,Pipline pipline,Parser parser,Integer threadCount,
                  ThreadPoolExecutor executor){
        this.urls = urls;
        this.pipline = pipline;
        this.parser =parser;
        this.threadCount = threadCount;
        this.threadPoolExecutor = executor;
    }

    public String[] getUrls() {
        return urls;
    }

    public Parser getParser() {
        return parser;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public Pipline getPipline() {
        return pipline;
    }
}
