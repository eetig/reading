package com.eetig.reading.account.service.impl;

import com.eetig.reading.account.dao.UserLikeSeeMapper;
import com.eetig.reading.account.service.UserLikeSeeService;
import com.reading.common.pojo.account.UserLikeSee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
