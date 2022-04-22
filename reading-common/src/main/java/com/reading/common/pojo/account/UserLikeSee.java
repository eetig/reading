package com.reading.common.pojo.account;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2022/4/9 周六 21:06
 * @Author xu
 * @FileName UserLikeSee
 * @Description
 */

/*
 * @Date 2022/4/10 09:31
 * @Author eetig
 * @Description 用户喜欢
 * @param null
 * @Return 
 **/
@Data
public class UserLikeSee implements Serializable {

    private static final long serialVersionUID = 2893263243645204203L;
    
    private Integer id;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 图书id
     */
    private String bookId;

    /**
     * 创建时间
     */
    private Date createTime;

}


