package com.github.spring.boot.swagger.controller;

import com.github.spring.boot.swagger.pojo.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * TODO
 * <p>
 * create in 2021/3/9 7:06 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Api(tags = "用户管理")
@RestController
public class UserInfoController {

    @ApiOperation("创建用户")
    @PostMapping("/users1")
    public UserInfoDTO create1(@RequestBody @Valid UserInfoDTO user, HttpServletRequest request) {
        return user;
    }

    @ApiOperation("创建用户")
    @PostMapping("/users2")
    public UserInfoDTO create2(@RequestBody @Valid UserInfoDTO user, @ApiIgnore HttpServletRequest request) {
        return user;
    }


}
