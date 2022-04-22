package com.eetig.reading.account.controller;

import com.eetig.reading.account.service.UserLikeSeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2022/4/9 周六 20:19
 * @Author xu
 * @FileName LikeSeeController
 * @Description controller
 */

@RestController
@RequestMapping("account/like-see")
@Api(description = "爱看")
public class UserLikeSeeController {

    @Autowired
    private UserLikeSeeService userLikeSeeService;

    @PostMapping("/list")
    @ApiOperation(value = "获取喜爱书单", httpMethod = "post")
    public String getUserLikeBookList(@Param(value = "userId") Integer userId) {
        return userLikeSeeService.getUserLikeBookList(userId);
    }
}
