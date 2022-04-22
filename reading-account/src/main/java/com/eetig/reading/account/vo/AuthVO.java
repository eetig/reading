package com.eetig.reading.account.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 认证VO
 * @author: zealon
 * @since: 2020/4/14
 */
@Data
public class AuthVO implements Serializable {
    private static final long serialVersionUID = -5767047071214290776L;
    private String token;
    private UserVO user;
}
