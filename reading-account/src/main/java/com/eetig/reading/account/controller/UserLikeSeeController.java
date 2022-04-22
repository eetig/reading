package com.eetig.reading.account.controller;

import cn.zealon.readingcloud.common.request.RequestParams;
import com.eetig.reading.account.service.UserLikeSeeService;
import com.reading.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @Date 2022/4/9 周六 20:19
 * @Author xu
 * @FileName LikeSeeController
 * @Description controller
 */

@RestController
@RequestMapping("account/like-see")
@Api(description = "用户爱看服务接口")
public class UserLikeSeeController {

    @Autowired
    private UserLikeSeeService userLikeSeeService;

    @PostMapping("/list")
    @ApiOperation(value = "获取喜爱书单", httpMethod = "post")
    public String getUserLikeBookList(@Param(value = "userId") Integer userId) {
        return userLikeSeeService.getUserLikeBookList(userId);
    }

    public Result likeSeeClick(@RequestHeader("userId") Integer userId, @RequestBody RequestParams params) {
        String bookId = params.getStringValue("bookId");
        Integer value = params.getIntValue("value");
        return this.userLikeSeeService.likeSeeClick(userId, bookId, value);

    }


}
