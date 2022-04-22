package com.eetig.reading.account.service;


import com.reading.common.result.Result;

/**
 * @Date 2022/4/9 周六 20:20
 * @Author xu
 * @FileName LikeSeeService
 * @Description service
 */

public interface UserLikeSeeService {

    String getUserLikeBookList(Integer userId);

    Result likeSeeClick(Integer userId, String bookId, Integer value);
}
