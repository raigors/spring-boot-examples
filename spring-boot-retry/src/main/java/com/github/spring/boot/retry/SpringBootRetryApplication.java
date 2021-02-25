package com.github.spring.boot.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author shishaodong
 */
@EnableRetry
@SpringBootApplication
public class SpringBootRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRetryApplication.class, args);
    }

}
