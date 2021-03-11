package com.github.spring.boot.swagger.controller.impl;

import com.github.spring.boot.swagger.controller.IUserInfoController;
import com.github.spring.boot.swagger.pojo.UserInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class UserInfoController implements IUserInfoController {

    @PostMapping("/users1")
    @Override
    public UserInfoDTO create(@RequestBody @Valid UserInfoDTO user, HttpServletRequest request) {
        return user;
    }

}
