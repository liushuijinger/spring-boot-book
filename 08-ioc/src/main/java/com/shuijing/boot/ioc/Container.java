package com.shuijing.boot.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
public class Container {

    private Map<Class<?>,Object> beans = new HashMap<>();

    public <T> T getBean(Class<T> key) {
        return (T) beans.get(key);
    }

    public <T> void put(Class<T> key, T value) {
        beans.put(key, value);
    }
}
