package com.eetig.reading.account.dao;
import com.reading.common.pojo.account.UserLikeSee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Date 2022/4/9 22:54
 * @Author eetig
 * @Description
 * @param
 * @Return
 **/
@Repository
public interface UserLikeSeeMapper {

    @Select("SELECT id, user_id as userId,book_id as bookId,create_time as createTime FROM user_like_see WHERE user_id=#{userId}")
    List<UserLikeSee> getUserLikeBookList(Integer userId);

}
