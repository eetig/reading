package com.reading.common.utils;

import java.util.Collection;
import java.util.UUID;

/**
 * @Date 2022/4/22 周五 21:45
 * @Author xu
 * @FileName CommonUtil
 * @Description 工具类
 */

public class CommonUtil {

    /**
     * @Date 2022/4/22 21:46
     * @Author eetig
     * @Description 判断集合为空
     * @param collection
     * @Return boolean
     **/
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty() || collection.size() <=0;
    }

    /**
     * @Date 2022/4/22 21:47
     * @Author eetig
     * @Description 判断集合为非空
     * @param collection
     * @Return boolean
     **/
    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    /**
     * @Date 2022/4/22 21:48
     * @Author eetig
     * @Description 随机生成UUID
     * @param
     * @Return java.lang.String
     **/
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }

}
