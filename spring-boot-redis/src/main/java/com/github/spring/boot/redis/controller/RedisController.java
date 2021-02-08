package com.github.spring.boot.redis.controller;

import com.github.spring.boot.redis.pojo.UserDO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * <p>
 * create in 2021/2/8 9:50 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final RedisTemplate<String, UserDO> redisTemplate;

    @PostMapping("/user")
    public UserDO createUser(@RequestBody UserDO user) {
        redisTemplate.opsForValue().set(user.getName(), user);
        return redisTemplate.opsForValue().get(user.getName());
    }

}
