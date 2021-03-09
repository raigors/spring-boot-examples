package com.github.spring.boot.logback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shishaodong
 */
@EnableScheduling
@SpringBootApplication
public class SpringBootLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogbackApplication.class, args);
    }

}
