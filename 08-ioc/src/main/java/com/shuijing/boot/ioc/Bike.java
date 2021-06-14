package com.shuijing.boot.ioc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
@Slf4j
public class Bike implements Driveable{
    @Override
    public void drive() {
        log.info("骑着自行车出去浪~");
    }
}
