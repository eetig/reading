package com.reading.common.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @Date 2022/4/23 周六 10:03
 * @Author xu
 * @FileName RequestParams
 * @Description
 */

public class RequestParams extends HashMap {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestParams.class);

    /**
     * @Date 2022/4/23 10:09
     * @Author eetig
     * @Description 获取整型参数
     * @param paramName
     * @Return java.lang.Integer
     **/
    public Integer getIntValue(String paramName) {
        Integer value = 0;
        Object object = this.get(paramName);
        if (object == null) {
            return value;
        }
        try {
            value = Integer.parseInt(this.get(paramName).toString());
        } catch (Exception e) {
            value = 0;
            LOGGER.error("获取参数{}转换整型异常! {}", paramName, e);
        }
        return value;
    }

    public String getStringValue(String paramName){
        String value = "";
        Object o = this.get(paramName);
        if (o == null) {
            return value;
        }
        return o.toString();
    }


}
