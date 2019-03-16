package com.seeker.analyze;

import com.seeker.network.Response;
import us.codecraft.xsoup.XElements;

/**
 * @author GregZQ
 * @create 2019-03-12 21:02
 * @des: 数据解析器
 */
public interface Parser<T> {

    T parse(Response response);
}
