package com.github.spring.boot.retry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.ThreadWaitSleeper;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * <p>
 * 创建时间为 下午4:00 2019/12/5
 * 项目名称 spring-boot-retry
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigRetryTemplate {

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate template = new RetryTemplate();
        //重试策略：次数重试策略
        RetryPolicy retryPolicy = new SimpleRetryPolicy(3);
        template.setRetryPolicy(retryPolicy);
        //退避策略：指数退避策略
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(100);
        backOffPolicy.setMaxInterval(3000);
        backOffPolicy.setMultiplier(2);
        backOffPolicy.setSleeper(new ThreadWaitSleeper());
        template.setBackOffPolicy(backOffPolicy);
        return template;
    }

}
