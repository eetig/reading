package com.reading.common.constant;

import com.reading.common.utils.MD5Util;

/**
 * @Date 2022/4/22 周五 16:54
 * @Author xu
 * @FileName UserUtil
 * @Description 用户工具类
 */

public class UserUtil {
    /**
     * @Date 2022/4/22 16:57
     * @Author eetig
     * @Description 获取盐值用于加密
     * @param loginName
     * @Return java.lang.String
     **/
    public static String getUserSalt(String loginName){
        //盐值
        String[] salts = {"sun","moon","star","sky","cloud","fog","rain","wind","rainbow"};
        int hashCode = loginName.hashCode() + 159 ;
        int mod = Math.abs(hashCode % 9);
        return salts[mod];

    }

    public static String getUserEncryptPassword(String loginName,String password){
        String pwdAndSalt = password + getUserSalt(loginName);
        return MD5Util.MD5Encode(pwdAndSalt,"utf-8");
    }

}
