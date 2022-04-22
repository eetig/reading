package com.reading.common.result;

import java.io.Serializable;

/**
 * @Date 2022/4/22 周五 18:07
 * @Author xu
 * @FileName Result
 * @Description 结果集封装
 */

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 7476342911695997517L;

    private int code;
    private String msg;
    private T data;

    /**
     * @param msg
     * @Date 2022/4/22 18:17
     * @Author eetig
     * @Description 构建消息内容
     * @Return com.reading.common.result.Result
     **/
    public Result buildMessage(String msg) {
        this.setMsg(msg);
        return this;
    }

    /**
     * @param obj
     * @Date 2022/4/22 18:17
     * @Author eetig
     * @Description 构建值, key默认为data
     * @Return com.reading.common.result.Result
     **/
    public Result buildData(T obj) {
        this.setData(obj);
        return this;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
