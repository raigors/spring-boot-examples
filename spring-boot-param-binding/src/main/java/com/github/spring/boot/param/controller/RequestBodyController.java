package com.github.spring.boot.param.controller;

import com.github.spring.boot.param.pojo.ResultVO;
import com.github.spring.boot.param.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:01 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class RequestBodyController {

    @PostMapping("body")
    public ResultVO<UserInfoDTO> body(@RequestBody UserInfoDTO userInfo) {
        log.debug("This is {} log", string());
        return ResultVO.success(userInfo);
    }

    private String string() {
        System.out.println("debug");
        return "debug";
    }

}
