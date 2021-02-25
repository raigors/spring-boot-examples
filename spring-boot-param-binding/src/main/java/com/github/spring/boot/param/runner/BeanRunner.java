package com.github.spring.boot.param.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/25 11:19 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Component
public class BeanRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        context.getBeansOfType(Object.class).forEach((k, v) -> {
            System.out.print(k + "   ");
            System.out.println(v.getClass());

        });


    }
}
