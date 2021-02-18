package com.github.spring.boot.param.controller;

import com.github.spring.boot.param.pojo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@RestController
public class RequestCookieController {

    @GetMapping("cookie")
    public ResultVO<String> cookie(@CookieValue(name = "testCookie") String testCookie) {
        log.debug("testCookie - {}", testCookie);
        return ResultVO.success(testCookie);
    }

}
