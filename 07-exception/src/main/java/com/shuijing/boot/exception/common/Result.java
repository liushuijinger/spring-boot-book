package com.shuijing.boot.exception.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error() {
        return error(MessageEnum.ERROR);
    }

    public static <T> Result<T> error(MessageEnum messageEnum) {
        return new Result<>(messageEnum.getCode(),messageEnum.getMessage(),null);
    }

    public static <T> Result<T> error(String message) {
        return error(message, MessageEnum.ERROR.getCode());
    }

    protected static <T> Result<T> error(String message,Integer code) {
        return new Result<>(code,message,null);
    }

}
