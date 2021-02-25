package com.github.spring.boot.retry.controller.impl;


import com.github.spring.boot.retry.controller.IRemoteController;
import com.github.spring.boot.retry.service.IRetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午3:26 2019/11/26
 * 项目名称 spring-boot-retry
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@RestController
public class RemoteControllerImpl implements IRemoteController {

    @Resource
    private IRetryService service;

    @GetMapping("/remote/{id}")
    @Override
    public String remote(@PathVariable String id) {
        return service.retry(id);
    }

}
