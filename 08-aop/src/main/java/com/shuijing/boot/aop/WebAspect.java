package com.shuijing.boot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-06-14
 */
@Slf4j
@Aspect
@Component
public class WebAspect {

    @Pointcut("execution(public * com.shuijing.boot.aop.*.*(..))")
    public void pointCut() {
    }

//    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Map<String, Object> paramMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }

        log.info("before path：{}",request.getServletPath());
        log.info("before class name：{}",className);
        log.info("before method name：{}",methodName);
        log.info("before args：{}",paramMap.toString());
    }

//    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("{} after", joinPoint.getSignature().getName());
    }

//    @AfterReturning(value = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint  joinPoint, Object returnVal) {
        log.info("{} after return, returnVal: {}", joinPoint.getSignature().getName(), returnVal);
    }

//    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint  joinPoint, Exception e) {
        log.info("{} after throwing, message: {}", joinPoint.getSignature().getName(), e.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("around start");
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("around error",e);
            return Result.error("around error");
        }
        long endTime = System.currentTimeMillis();
        log.info("execute time：{} ms",endTime - startTime);
        log.info("returnVal: {}", result);
        log.info("around end");
        return result;
    }
}