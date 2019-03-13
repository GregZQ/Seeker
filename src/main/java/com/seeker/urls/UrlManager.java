package com.seeker.urls;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author GregZQ
 * @create 2019-03-12 21:03
 * @des: URL管理器
 */
public class UrlManager {
    //用于去重
    private Set<String> urlSet = new HashSet<String>();
    //处理完成的url
    private Set<String> handleUrl = new HashSet<String>();
    //线程数
    private volatile int count;
    /**
     * 添加url
     * @param url
     */
    public void addUrl(String url){

        synchronized (this){
            //判断当前url是否已经被处理
            if (!handleUrl.contains(url)){
                urlSet.add(url);
                count++;
            }
        }
    }

    /**
     * 从url队列当中获取一个url进行处理
     * @return
     */
    public String getUrl(){
        synchronized (this){
            //找出一个url进行处理
            Iterator<String> iterator = urlSet.iterator();
            while (iterator.hasNext()){
                String value = iterator.next();
                handleUrl.add(value);
                iterator.remove();
                count--;
                return value;
            }
            return null;
        }
    }

    public int getCount() {
        return count;
    }
}
