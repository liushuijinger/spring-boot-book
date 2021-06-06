package com.shuijing.boot.exception.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-05-30
 */
@Slf4j
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Boolean> globalException(Exception e) {
        Result<Boolean> result = new Result<>();
        result.setCode(MessageEnum.ERROR.getCode());
        result.setMessage(e.getMessage() == null ? MessageEnum.ERROR.getMessage() : e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }

    @ExceptionHandler(ApiException.class)
    public Result<Boolean> apiException(ApiException e) {
        Result<Boolean> result = new Result<>();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }

}
