package com.example.tea.admin.server.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/07/04 16:37
 */
@Slf4j
@Aspect
@Component
public class TimerAspect {
    @Around("execution(* com.example.tea.admin.server..service.*.*(..))")
    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceedResult = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("执行耗时: {}ms", end - start);
        return proceedResult;
    }
}
