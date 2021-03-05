package com.github.spring.boot.rest.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 * <p>
 * create in 2021/3/5 5:08 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
