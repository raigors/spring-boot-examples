package com.github.spring.boot.controller.advice.exception.handler;

import com.github.spring.boot.controller.advice.pojo.UserDO;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 创建时间为 09:54 2019-04-27
 * 项目名称 spring-boot-controlleradvice
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */



@Order(2)
@RestControllerAdvice
public class UserExceptionHandler2 {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public UserDO handler(Exception exception) {
        UserDO entity = new UserDO();
        entity.setName("11111111");
        entity.setPass("22222222");
        return entity;
    }
}
