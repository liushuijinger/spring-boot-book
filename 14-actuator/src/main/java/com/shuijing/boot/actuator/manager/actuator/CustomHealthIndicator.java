package com.shuijing.boot.actuator.manager.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.util.Random;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021/12/14
 */
//@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean result = check();
        if (!result) {
            return Health.down().withDetail("message","出错了").build();
        }
        return Health.up().build();
    }

    // 自定义检查逻辑
    private boolean check() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        return randomNum % 2 == 0;
    }

}