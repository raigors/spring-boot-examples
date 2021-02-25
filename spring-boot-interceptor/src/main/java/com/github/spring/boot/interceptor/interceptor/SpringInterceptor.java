package com.github.spring.boot.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 * <p>
 * create in 2021/2/25 9:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class SpringInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        log.info("------------------ preHandle");
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        long before = (long) request.getAttribute("startTime");
        long after = System.currentTimeMillis();
        System.out.println("耗时:" + (after - before));
        log.info("------------------ postHandle");

    }
}