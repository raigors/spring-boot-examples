package com.github.spring.boot.controller.advice.exception.handler;

import com.github.spring.boot.controller.advice.exception.UserException;
import com.github.spring.boot.controller.advice.pojo.UserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

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
@Order(1)
@RestControllerAdvice
public class UserExceptionHandler {

    //    @Order(HIGHEST_PRECEDENCE)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = UserException.class)
    public UserDO handler1(@NotNull UserException exception) {
        UserDO entity = exception.getUserDO();
        entity.setName("aaaaaaa");
        entity.setPass("1111111");
        return entity;
    }


    @Order(2)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public UserDO handler(ConstraintViolationException e) {
        UserDO entity = new UserDO();
        entity.setName("ConstraintViolationException");
        entity.setPass("ConstraintViolationException");
        return entity;
    }


    //    @Order(2)
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public UserDO handler(MethodArgumentNotValidException e) {
        UserDO entity = new UserDO();
        entity.setName("MethodArgumentNotValidException");
        entity.setPass("MethodArgumentNotValidException");
        return entity;
    }

}
