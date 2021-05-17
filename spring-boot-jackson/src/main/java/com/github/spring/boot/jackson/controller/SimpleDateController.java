package com.github.spring.boot.jackson.controller;

import com.github.spring.boot.jackson.pojo.SimpleDateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * create in 2021/5/13 2:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
public class SimpleDateController {

    @PostMapping("simple/date")
    public SimpleDateDTO simpleDate(@RequestBody SimpleDateDTO data) {
        log.info("请求的数据:{}", data);
        return new SimpleDateDTO(data.getStartDate(), data.getEndDate());
    }

}
