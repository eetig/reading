package com.eetig.reading.account.service.impl;

import com.eetig.reading.account.dao.UserLikeSeeMapper;
import com.eetig.reading.account.service.UserLikeSeeService;
import com.eetig.reading.account.service.task.LikeSeeClickTask;
import com.reading.common.cache.RedisService;
import com.reading.common.pojo.account.UserLikeSee;
import com.reading.common.result.Result;
import com.reading.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @Date 2022/4/9 周六 20:21
 * @Author xu
 * @FileName UserLikeSeeServiceImpl
 * @Description
 */
@Service
public class UserLikeSeeServiceImpl implements UserLikeSeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLikeSeeServiceImpl.class);

    @Autowired
    private UserLikeSeeMapper userLikeSeeMapper;

    //redis服务
    @Autowired
    private RedisService redisService;

    @Autowired
    private ExecutorService commonQueueThreadPool;


    @Override
    public String getUserLikeBookList(Integer userId) {
        String userLikeBookListStr = "";
        try {
            //
            List<UserLikeSee> userLikeBookList = userLikeSeeMapper.getUserLikeBookList(userId);
            userLikeBookListStr = userLikeBookList.toString();
        } catch (Exception ex) {
            LOGGER.error("用户喜欢异常：{}", ex);
        }
        return userLikeBookListStr;
    }

    @Override
    public Result likeSeeClick(Integer userId, String bookId, Integer value) {
        try {
            // 0 取消喜欢  1 增加喜欢
            if ( value == 0) {
                this.userLikeSeeMapper.deletByUserIdAndBookId(userId,bookId);
            } else {
                UserLikeSee likeSee = new UserLikeSee();
                likeSee.setUserId(userId);
                likeSee.setBookId(bookId);
                this.userLikeSeeMapper.insert(likeSee);
            }
            //更新缓存
            LikeSeeClickTask task = new LikeSeeClickTask(redisService, bookId, value);
            this.commonQueueThreadPool.execute(task);
        } catch (Exception e) {
            LOGGER.error("likeclick操作异常: {}",e);
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

}
