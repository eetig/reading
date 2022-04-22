package com.eetig.reading.account.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户书架上报数据 BO
 * @author: zealon
 * @since: 2020/4/13
 */
@Data
public class UserBookshelfBO implements Serializable {

    private static final long serialVersionUID = 723048038138578726L;
    private Integer id;

    /**
     * 同步类型：
     * 1.新增  2.更新  3.删除
     */
    private int syncType;

    /** 图书id */
    private String bookId;

    /** 最后章节ID */
    private Integer lastChapterId;
}
