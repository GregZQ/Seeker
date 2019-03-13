package com.seeker.engine;

import com.seeker.Spider;
import com.seeker.analyze.Parser;
import com.seeker.dispatch.Scheduler;
import com.seeker.download.Downloader;
import com.seeker.exception.SeekerException;
import com.seeker.network.Request;
import com.seeker.pipline.Pipline;
import com.seeker.urls.UrlManager;

import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author GregZQ
 * @create 2019-03-12 20:56
 * @des: 爬虫引擎，用于启动爬虫
 */
public class SeekerEngine {

    private Spider spider;
    //中心调度器
    private Scheduler scheduler;
    //解析器
    private Parser parser;
    //下载器
    private Downloader downloader;
    //url管理器
    private UrlManager urlManager;
    //处理管道处理器
    private Pipline pipline;
    //线程管理器
    private ThreadPoolExecutor threadPoolExecutor;
    //启动线程数
    private int threadCount;
    //自定义request请求
    private Request request;

    private SeekerEngine(){
    }

    public static SeekerEngine  me(Spider spider){
        SeekerEngine seekerEngine = new SeekerEngine();
        seekerEngine.spider=spider;
        return seekerEngine;
    }
    //添加request请求
    public SeekerEngine addRequest(Request request){
        this.request = request;
        return this;
    }

    public void run() throws Exception {
        //初始化
        init();

        while (true) {
            for(int i = 0;i<threadCount;i++){
                threadPoolExecutor.execute(
                        new Scheduler(downloader,pipline,parser,urlManager,request)
                );
            }
        }
    }

    private void init() throws Exception{
        //初始化url管理器
        String[] urls =  spider.getUrls();
        if (urls == null||urls.length == 0){
            throw new SeekerException("url不能为空");
        }
        this.urlManager = new UrlManager();
        for (String url : urls) {
            this.urlManager.addUrl(url);
        }
        if(Objects.isNull(request)){
            this.request = Request.newInstance();
        }
        //初始化下载器
        this.downloader = new Downloader();
        //初始化解析器
        this.parser = spider.getParser();
        //初始化管道处理器
        this.pipline = spider.getPipline();
        //初始化线程池
        this.threadPoolExecutor = spider.getThreadPoolExecutor();
        //初始化线程数
        this.threadCount = spider.getThreadCount();
    }
}
