package com.github.spring.boot.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * <p>
 * create in 2021/2/5 10:04 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

}
