package com.github.spring.boot.jackson.controller;

import com.github.spring.boot.jackson.pojo.JsonPropertyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 别名处理
 * <p>
 * 创建时间为 21:25-2019-04-22
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Slf4j
@RestController
public class JsonPropertyController {

    @PostMapping("property")
    public JsonPropertyDTO getJsonProperty(@RequestBody JsonPropertyDTO jsonProperty) {
        log.info("接收到数据:{}", jsonProperty);
        return jsonProperty;
    }

}
