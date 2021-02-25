package com.github.spring.boot.interceptor.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/25 9:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Validated
@RestController
public class SpringController {

    @GetMapping("/aaa/{param}")
    public String aaa(@PathVariable @Length(min = 4) String param) {
        return param;
    }

}
