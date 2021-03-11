package com.github.spring.boot.swagger.controller;

import com.github.spring.boot.swagger.pojo.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * TODO
 * <p>
 * create in 2021/3/11 3:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Api(tags = "用户管理")
public interface IUserInfoController {

    @ApiOperation("创建用户")
    UserInfoDTO create(@Valid UserInfoDTO user, @ApiIgnore HttpServletRequest request);

}
