package com.github.spring.boot.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;

/**
 * @author shishaodong
 */
@EnableElasticsearchAuditing
@SpringBootApplication
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }

}
