package com.github.spring.boot.jackson.controller;

import com.github.spring.boot.jackson.pojo.SerializationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-10-23 15:18
 * @since 1.0
 */

@Slf4j
@RestController
public class SerializationController {

    /**
     * 传入数据格式, mobiles 自定转换为 Set
     * "{\"username\":\"test_username\",\"mobiles\":\"18888888888|18888888889\"}"
     *
     * @param deserialize 反序列化对象
     * @return SerializationDTO
     */
    @PostMapping("de")
    public SerializationDTO serialize(@RequestBody SerializationDTO deserialize) {
        log.info("接收到数据:{}", deserialize);
        return deserialize;
    }

}
