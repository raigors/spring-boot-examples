package com.github.spring.boot.retry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 创建时间为 下午3:14 2019/11/26
 * 项目名称 spring-boot-retry
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
public class ConfigRestTemplate {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
