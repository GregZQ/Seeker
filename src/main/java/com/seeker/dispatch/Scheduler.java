package com.seeker.dispatch;

import com.seeker.analyze.Parser;
import com.seeker.download.Downloader;
import com.seeker.network.Request;
import com.seeker.pipline.Pipline;
import com.seeker.urls.UrlManager;
import org.apache.commons.lang3.StringUtils;

/**
 * @author GregZQ
 * @create 2019-03-12 21:05
 * @des: 调度器
 */
public class Scheduler implements Runnable {
    //下载器
    private Downloader downloader;
    //管道
    private Pipline pipline;
    //解析器
    private Parser parser;
    //url管理器
    private UrlManager urlManager;
    //请求管理器
    private Request request;
    public Scheduler(Downloader downloader, Pipline pipline,
                     Parser parser, UrlManager urlManager,Request request){
        this.downloader = downloader;
        this.pipline = pipline;
        this.parser = parser;
        this.urlManager = urlManager;
        this.request = copyRequest(request);
    }

    public void run() {
        //在url
        String url;
        while (this.urlManager.getCount()!=0){
            url = this.urlManager.getUrl();
            if (StringUtils.isEmpty(url)){
                break;
            }
            request.setUserAgent(url);
            downloader.handle(request);
        }
    }

    private Request copyRequest(Request request) {
        this.request = Request.newInstance();
        this.request.setUserAgent(request.getUserAgent());
        this.request.setMethod(request.getMethod());
        this.request.setConnectTimeout(request.getConnectTimeout());
        this.request.setConnectionRequestTimeout(request.getConnectionRequestTimeout());
        this.request.setHead(request.getHead());
        return request;
    }
}
