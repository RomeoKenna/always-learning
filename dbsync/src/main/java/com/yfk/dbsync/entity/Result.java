package com.yfk.dbsync.entity;

/**
 * ClassName:Result
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 14:18
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    /**
     * 响应码，success，fail
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public Result(String code,
                  String message,
                  T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result<Object> fail(String message) {
        return new Result<>("fail", message, null);
    }

    public static <T> Result<T> fail(String message,
                                     T t) {
        return new Result<>("fail", message, t);
    }

    public static Result<Object> success(String message) {
        return new Result<>("success", message, null);
    }

    public static <T> Result<T> success(String message,
                                        T t) {
        return new Result<>("success", message, t);
    }

    public static <T> Result<T> success(T t) {
        return new Result<>("success", "message", t);
    }

    public Boolean isSuccess() {
        if ("success".equals(this.getCode())) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
