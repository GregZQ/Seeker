package com.seeker.download;

import com.seeker.exception.SeekerException;
import com.seeker.network.Request;
import com.seeker.network.Response;
import com.seeker.properties.RequestMethod;
import com.seeker.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author GregZQ
 * @create 2019-03-12 20:57
 * @des: 下载器，用于下载网页
 */
public class Downloader {
    private static final Logger logger = LoggerFactory.getLogger(Downloader.class);

    //下载器下载
    public Response handle(Request request) throws Exception {
        logger.info("开始请求下载-----");
        InputStream inputStream = null;
        if (RequestMethod.GET.match(request.getMethod())){
            inputStream = HttpClientUtils.getHtml(request);
        }else if (RequestMethod.POST.match(request.getMethod())){
            inputStream = HttpClientUtils.postHtml(request);
        }else {
            throw new SeekerException("请求方法不存在");
        }
        return new Response(inputStream);
    }
}
