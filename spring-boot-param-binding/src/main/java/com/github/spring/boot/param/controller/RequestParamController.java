package com.github.spring.boot.param.controller;

import com.github.spring.boot.param.pojo.ResultVO;
import com.github.spring.boot.param.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/18 4:03 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
public class RequestParamController {

    @GetMapping("param1")
    public ResultVO<String> param1(@RequestParam(name = "name") String name) {
        return ResultVO.success(name);
    }

    @GetMapping("param2")
    public ResultVO<UserInfoDTO> param2(UserInfoDTO user) {
        return ResultVO.success(user);
    }
}
