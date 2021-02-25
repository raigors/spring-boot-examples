package com.github.spring.boot.filter.controller;


import com.github.spring.boot.filter.pojo.DataDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 创建时间为 下午6:41 2019/12/7
 * 项目名称 spring-boot-filter
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class BodyReadController {

    @GetMapping("/date1")
    public Date getDate() {
        return new Date();
    }

    @GetMapping("/date2")
    public String getDate2() {
        return "getDate2";
    }

    @PostMapping("/test1")
    public DataDTO post1(@RequestBody DataDTO dto) {
        return dto;
    }

    @PostMapping("/test2")
    public DataDTO post2(@RequestBody DataDTO dto) {
        return dto;
    }

    @GetMapping("/path/{data}")
    public String path(@PathVariable String data){
        return data;
    }
}
