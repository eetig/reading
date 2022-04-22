package com.eetig.reading.account.common.utils;

import com.eetig.reading.account.vo.UserVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import static com.reading.common.constant.JwtConstant.SECRET_KEY;

/**
 * @Date 2022/4/22 周五 16:38
 * @Author xu
 * @FileName JwtUtil
 * @Description 登录认证
 */

public class JwtUtil {
    /**
     * @Date 2022/4/22 16:43
     * @Author eetig
     * @Description 构建JWT对象
     * @param expire
     * @param user
     * @Return java.lang.String
     **/
    public static String buildJwt(Date expire, UserVO user){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .claim("loginName", user.getLoginName())
                .claim("nickName", user.getNickName())
                .claim("phoneNumber", user.getPhoneNumber())
                .claim("headImgUrl", user.getUuid())
                .claim("id", user.getId())
                .compact();
        return jwt;

    }


}
