package com.github.spring.boot.cache.controller.impl;

import com.github.spring.boot.cache.controller.IUserDetailController;
import com.github.spring.boot.cache.pojo.dto.UserCreateDTO;
import com.github.spring.boot.cache.pojo.dto.UserQueryDTO;
import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import com.github.spring.boot.cache.pojo.vo.ReturnVO;
import com.github.spring.boot.cache.service.IUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户增删改查接口实现
 * <p>
 * create in 2021/2/7 4:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RequiredArgsConstructor
@RestController
public class UserDetailControllerImpl implements IUserDetailController {

    private final IUserDetailService service;

    @GetMapping("/users")
    @Override
    public ReturnVO<PageImpl<UserDetailDO>> listUsers(UserQueryDTO query, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ReturnVO.success(service.listUsers(query, pageable));
    }

    @PostMapping("/user")
    @Override
    public ReturnVO<UserDetailDO> create(@RequestBody UserCreateDTO userDetail) {
        return ReturnVO.success(service.create(userDetail.getUserDetailEntity()));
    }

    @PutMapping("/user")
    @Override
    public ReturnVO<UserDetailDO> update(@RequestBody UserCreateDTO userDetail) {
        return ReturnVO.success(service.update(userDetail.getUserDetailEntity()));
    }

    @DeleteMapping("/user/{name}")
    @Override
    public ReturnVO<String> delete(@PathVariable String name) {
        return ReturnVO.success(service.delete(name));
    }

    @DeleteMapping("/users/all")
    @Override
    public ReturnVO<String> deleteAll() {
        return ReturnVO.success(service.deleteAll());
    }
}


