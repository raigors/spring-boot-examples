package com.github.spring.boot.controller.advice.controller;


import com.github.spring.boot.controller.advice.exception.UserException;
import com.github.spring.boot.controller.advice.pojo.UserDO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * <p>
 * 创建时间为 09:51 2019-04-27
 * 项目名称 spring-boot-controlleradvice
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Validated
@RestController
public class UserController {

    @GetMapping("/")
    public UserDO getEntity1() {
        UserDO entity = new UserDO();
        entity.setName("nnnnnnnnnn");
        entity.setPass("vvvvvvvvvv");
        throw new UserException(entity);
    }

    @PostMapping("/body")
    public UserDO getEntity2(@RequestBody @Valid UserDO user) {
        UserDO entity = new UserDO();
        entity.setName("RequestBody");
        entity.setPass("RequestBody");
        throw new UserException(entity);
    }

    @GetMapping("/{id}")
    public UserDO getEntity3(@Min(200) @PathVariable int id) {
        UserDO entity = new UserDO();
        entity.setName("nnnnnnnnnn" + id);
        entity.setPass("vvvvvvvvvv" + id);
        throw new UserException(entity);
    }
}
