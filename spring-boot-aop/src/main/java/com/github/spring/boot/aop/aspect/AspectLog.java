package com.github.spring.boot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP:动态代理
 * 指定程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式.
 * <p>
 * 1.导入 aop 模块:
 * 2.定义一个逻辑类
 * 3.定义一个日志切面类
 * 通知方法:
 * 前置通知:在目标方法运行之前运行
 * 后置通知:在目标方法运行结束运行(无论方法是正常结束还是异常结束)
 * 返回通知:在目标方法运行正常返回通知
 * 异常通知:在目标方法运行出现异常通知
 * 环绕通知:在目标方法运行执行前后通知
 * <p>
 * create in 2021/2/22 9:36 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Aspect
@Component
public class AspectLog {

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(* com.github.spring.boot.aop.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知:在目标方法运行之前运行
     *
     * @param joinPoint joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("logStart...{} - {}", joinPoint.getSignature().getName(), Arrays.asList(args));
    }

    /**
     * 后置通知:在目标方法运行结束运行(无论方法是正常结束还是异常结束)
     *
     * @param joinPoint joinPoint
     */
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        log.info("logEnd...");
    }

    /**
     * 返回通知:在目标方法运行正常返回通知
     *
     * @param result result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        log.info("logReturn...");
    }

    /**
     * 异常通知:在目标方法运行出现异常通知
     *
     * @param exception 异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logThrown(Exception exception) {
        log.info("logThrown...");
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        log.info("logAround...运行...参数列表是:{}", Arrays.asList(pdj.getArgs()));
        return pdj.proceed();
    }

}