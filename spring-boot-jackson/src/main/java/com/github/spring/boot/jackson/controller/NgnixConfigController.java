package com.github.spring.boot.jackson.controller;

import com.github.spring.boot.jackson.pojo.NginxConfDTO;
import com.github.spring.boot.jackson.service.INginxConfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回不同的格式, MVC ?
 * <p>
 * create in 2021/5/13 3:56 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class NgnixConfigController {

    @PostMapping("nginx/conf")
    public NginxConfDTO nginxConf(@RequestBody NginxConfDTO nginxConf) {
        return nginxConf;
    }

    private final INginxConfService service;

    @PostMapping("nginx/conf2")
    public NginxConfDTO nginxConf2(@RequestBody NginxConfDTO nginxConf) {
        // OCP 原则
        nginxConf.generateConf(service);
        return nginxConf;
    }

}
