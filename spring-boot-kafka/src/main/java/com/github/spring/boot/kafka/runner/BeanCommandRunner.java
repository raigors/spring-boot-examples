package com.github.spring.boot.kafka.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

/**
 * 打印所有的 Bean
 * <p>
 * create in 2021/3/25 2:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Component
public class BeanCommandRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        context.getBeansOfType(Object.class).forEach((k, v) -> {
            System.out.print(k + "       ");
            System.out.println(v.getClass().getName());
        });

    }
}
