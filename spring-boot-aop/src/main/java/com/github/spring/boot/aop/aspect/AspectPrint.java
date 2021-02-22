package com.github.spring.boot.aop.aspect;

import com.github.spring.boot.aop.annotation.Print;
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
 * create in 2021/2/22 9:48 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(3)
@Aspect
@Component
public class AspectPrint {

    @Pointcut("@annotation(print)")
    public void pointCut(Print print) {
    }

    @Around(value = "pointCut(print)")
    public Object logAround(ProceedingJoinPoint pjp, Print print) throws Throwable {
        Object response = pjp.proceed();
        log.info("AspectAnnotation - {}", print.value());
        return response;
    }

}
