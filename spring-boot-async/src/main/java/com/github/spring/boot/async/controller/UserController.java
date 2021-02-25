package com.github.spring.boot.async.controller;


import com.github.spring.boot.async.pojo.UserDO;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 * 创建时间为 20:06 2019-04-27
 * 项目名称 spring-boot-async
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class UserController {

    @GetMapping("/user")
    @SneakyThrows({ExecutionException.class, InterruptedException.class, TimeoutException.class})
    public UserDO getUserDO() {
        return getDao().get(1, TimeUnit.MILLISECONDS);
    }

    @Async
    public Future<UserDO> getDao() {
        return AsyncResult.forValue(userFactory());
    }

    @NotNull
    private UserDO userFactory() {
        UserDO userDO = new UserDO();
        userDO.setName("name:" + new Date());
        userDO.setPass("pass:" + new Date());
        return userDO;
    }


}
