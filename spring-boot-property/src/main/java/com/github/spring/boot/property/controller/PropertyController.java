package com.github.spring.boot.property.controller;

import com.github.spring.boot.property.config.ConfigProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 创建时间为 15:22 2019-04-10
 * 项目名称 spring-boot-property
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class PropertyController {

    @Resource
    private ConfigProperty property;

    @GetMapping("map")
    public Map<String, String> getMap() {
        return property.getMap();
    }

    @GetMapping("list")
    public List<String> getList() {
        return property.getList();
    }

    @GetMapping("/")
    public ConfigProperty getConfigProperty() {
        return property;
    }


}
