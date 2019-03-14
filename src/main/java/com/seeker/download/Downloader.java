package com.seeker.download;

import com.seeker.network.Request;
import com.seeker.properties.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author GregZQ
 * @create 2019-03-12 20:57
 * @des: 下载器，用于下载网页
 */
public class Downloader {
    private static final Logger logger = LoggerFactory.getLogger(Downloader.class);
    //下载器下载
    public void handle(Request request) {
        logger.info("开始请求下载-----");
        if (RequestMethod.GET.match(request.getMethod())){
        }
    }
}
