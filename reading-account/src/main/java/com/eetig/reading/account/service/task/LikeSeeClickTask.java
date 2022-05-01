package com.eetig.reading.account.service.task;

import com.reading.common.cache.RedisAccountKey;
import com.reading.common.cache.RedisService;

/**
 * @Date 2022/4/22 周五 20:36
 * @Author xu
 * @FileName LikeSeeClickTask
 * @Description 同步用户喜爱
 */

public class LikeSeeClickTask implements Runnable {

    private RedisService redisService;
    private String bookId;
    private Integer value;

    @Override
    public void run() {
        //喜欢数若存在,进行相应的递增或递减
        if (this.redisService.hashHasKey(RedisAccountKey.ACCOUNT_CENTER_BOOK_LIKES_COUNT,this.bookId)) {
            int val = 1;
            if (value <= 0) {
                val = -1;
            }
            this.redisService.hashIncrement(RedisAccountKey.ACCOUNT_CENTER_BOOK_LIKES_COUNT,this.bookId,val);
        }

    }

    public LikeSeeClickTask() {
    }

    public LikeSeeClickTask(RedisService redisService, String bookId, Integer value) {
        this.redisService = redisService;
        this.bookId = bookId;
        this.value = value;
    }
}
