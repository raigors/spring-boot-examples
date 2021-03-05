package com.github.spring.boot.elasticsearch.controller;

import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import com.github.spring.boot.elasticsearch.repository.IFlowLogBasicRepository;
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
    private IFlowLogBasicRepository repository;

    @GetMapping("/users")
    public Page<FlowLogDO> findAllUsers(@PageableDefault(page = 1) Pageable pageable) {
        return repository.findAllBy(pageable, FlowLogDO.class);
    }

    @GetMapping("/user/{username}")
    public FlowLogDO existsByUsername(@PathVariable String username) {
        return repository.existsByUsernameEquals(username);
    }

}
