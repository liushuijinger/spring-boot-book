package com.shuijing.boot.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
@Slf4j
public class Ship implements Driveable{
    @Override
    public void drive() {
        log.info("坐船出去浪~");
    }
}
