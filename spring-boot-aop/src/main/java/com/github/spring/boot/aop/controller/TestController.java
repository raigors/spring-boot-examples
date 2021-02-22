package com.github.spring.boot.aop.controller;

import com.github.spring.boot.aop.annotation.Print;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/22 9:17 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class TestController {

    @GetMapping("/div/{data}")
    public int div(@PathVariable Integer data) {
        return 100 / data;
    }

    @Print("get message")
    @GetMapping("/message/{data}")
    public String print(@PathVariable String data) {
        return data;
    }

}
