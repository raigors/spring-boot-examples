package com.github.spring.boot.retry.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午3:58 2019/12/5
 * 项目名称 spring-boot-retry
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class ManualRetryController {

    @Resource
    private RetryTemplate retryTemplate;
    int a = 0;

    @GetMapping("/manual")
    public String get() throws Throwable {
        return retryTemplate.execute((RetryCallback<String, Throwable>) context -> getString());
    }

    @GetMapping("/manual2")
    public String get2() throws Throwable {
        return retryTemplate.execute((RetryCallback<String, Throwable>) context -> getString(),
                new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext retryContext) throws Exception {
                return recover(retryContext);
            }
        });
    }

    @NotNull
    private String getString() {
        System.out.println(new Date().toString());
        return (1 / a) + "";
    }


    private String recover(Exception e) {
        return "ERROR";
    }


}
