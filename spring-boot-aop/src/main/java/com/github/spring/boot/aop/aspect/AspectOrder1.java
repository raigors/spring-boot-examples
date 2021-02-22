package com.github.spring.boot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 * <p>
 * create in 2021/2/22 9:42 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(1)
@Aspect
@Component
public class AspectOrder1 {

    @Pointcut("execution(* com.github.spring.boot.aop.controller.*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        log.info("order1");
        return pdj.proceed();
    }

}
