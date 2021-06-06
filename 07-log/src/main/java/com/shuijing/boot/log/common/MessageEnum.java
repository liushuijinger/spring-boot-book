package com.shuijing.boot.log.common;

import lombok.Getter;

/**
 * 消息枚举类
 *
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-5-30
 */
@Getter
public enum MessageEnum {
    ERROR(500, "系统错误"),
    SUCCESS(0, "操作成功！"),
    ;
    private final Integer code;
    private final String message;

    MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}