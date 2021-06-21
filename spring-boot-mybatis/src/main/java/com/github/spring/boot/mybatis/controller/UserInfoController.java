package com.github.spring.boot.mybatis.controller;

import com.github.spring.boot.mybatis.pojo.UserInfoDO;
import com.github.spring.boot.mybatis.repository.IUserInfoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-12-03 14:43
 * @since 1.0
 */

@RestController
public class UserInfoController {

    @Resource
    private IUserInfoMapper mapper;

    @GetMapping("{id}")
    UserInfoDO findById(@PathVariable long id) {
        return mapper.selectFromUserInfoByUserId(id);
    }

    @GetMapping("/users")
    Page<UserInfoDO> findAll(Pageable pageable) {


        return null;
    }


}
