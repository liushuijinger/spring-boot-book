package com.shuijing.boot.ioc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Driveable driveable;

    public void hangOut() {
        driveable.drive();
    }
}
