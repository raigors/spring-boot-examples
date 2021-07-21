package com.github.spring.boot.smart.doc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * <p>
 * create in 2021/6/23 2:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class SmartDocController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
