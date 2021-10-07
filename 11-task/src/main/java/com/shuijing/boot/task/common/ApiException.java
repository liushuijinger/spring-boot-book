package com.shuijing.boot.task.common;

import lombok.Data;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-30
 */
@Data
public class ApiException extends RuntimeException {

    private Integer code;

    public ApiException(MessageEnum messageEnum) {
        super(messageEnum.getMessage());
        this.code = messageEnum.getCode();
    }

    public ApiException(String message) {
        super(message);
        this.code = 500;
    }

}
