package com.shuijing.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
@Slf4j
//@Order(1)
@Aspect
@Component
public class AspectOne {

    @Pointcut("execution(public * com.shuijing.boot.aop.*.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before() {
        log.info("before one");
    }

    @After(value = "pointCut()")
    public void after() {
        log.info("after one");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        log.info("afterReturning one");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("around one start");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("around error",e);
        }
        log.info("around one end");
        return result;
    }
}