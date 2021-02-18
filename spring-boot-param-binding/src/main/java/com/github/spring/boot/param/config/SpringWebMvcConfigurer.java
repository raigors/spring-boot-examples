package com.github.spring.boot.param.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/9 6:15 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private HandlerInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

}