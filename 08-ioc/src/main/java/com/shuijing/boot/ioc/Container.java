package com.shuijing.boot.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
public class Container {

    private Map<Class<?>,Object> map = new HashMap<>();

    public <T> T getBean(Class<T> key) {
        return (T) map.get(key);
    }

    public <T> void put(Class<T> key, T value) {
        map.put(key, value);
    }
}
