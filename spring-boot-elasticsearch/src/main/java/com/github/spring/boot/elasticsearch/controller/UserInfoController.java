package com.github.spring.boot.elasticsearch.controller;

import com.github.spring.boot.elasticsearch.pojo.orm.UserInfoDO;
import com.github.spring.boot.elasticsearch.repository.IUserInfoBasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/19 11:08 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
public class UserInfoController {

    @Resource
    private IUserInfoBasicRepository repository;

    @GetMapping("/users")
    public Page<UserInfoDO> findAllUsers(@PageableDefault(page = 1) Pageable pageable) {
        return repository.findAllBy(pageable, UserInfoDO.class);
    }

    @GetMapping("/user/{username}")
    public UserInfoDO existsByUsername(@PathVariable String username) {
        return repository.existsByUsernameEquals(username);
    }

}
