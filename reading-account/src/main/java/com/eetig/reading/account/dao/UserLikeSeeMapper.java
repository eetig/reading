package com.eetig.reading.account.dao;

import com.reading.common.pojo.account.UserLikeSee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @param
 * @Date 2022/4/9 22:54
 * @Author eetig
 * @Description
 * @Return
 **/
@Repository
public interface UserLikeSeeMapper {

    @Select("SELECT id, user_id as userId,book_id as bookId,create_time as createTime FROM user_like_see WHERE user_id=#{userId}")
    List<UserLikeSee> getUserLikeBookList(Integer userId);

    @Select("DELETE FROM user_like_see WHERE user_id = #{userId} and book_id = #{bookId} ")
    void deletByUserIdAndBookId(Integer userId, String bookId);

    @Select("INSERT INTO user_like_see (id,user_id,book_id,create_time) VALUES (#{likeSee.id},#{likeSee.userId},#{likeSee.bookId})")
    void insert(UserLikeSee likeSee);
}
