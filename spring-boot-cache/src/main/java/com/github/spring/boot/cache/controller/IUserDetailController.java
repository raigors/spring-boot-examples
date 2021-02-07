package com.github.spring.boot.cache.controller;

import com.github.spring.boot.cache.pojo.dto.UserCreateDTO;
import com.github.spring.boot.cache.pojo.dto.UserQueryDTO;
import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import com.github.spring.boot.cache.pojo.vo.ReturnVO;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户增删改查接口
 * <p>
 * create in 2021/2/7 4:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserDetailController {

    /**
     * 查询所有的用户
     *
     * @param query    查询条件
     * @param pageable 分页信息
     * @return Page
     */
    ReturnVO<PageImpl<UserDetailDO>> listUsers(UserQueryDTO query, Pageable pageable);

    /**
     * 新增用户
     *
     * @param userDetailDO 用户信息
     * @return UserDetailDO
     */
    ReturnVO<UserDetailDO> create(@RequestBody UserCreateDTO userDetailDO);

    /**
     * 修改用户信息
     *
     * @param userDetailDO 用户信息
     * @return UserDetailDO
     */
    ReturnVO<UserDetailDO> update(@RequestBody UserCreateDTO userDetailDO);

    /**
     * 根据用户名删除用户
     *
     * @param name 根据用户名删除用户
     * @return ResponseEntity
     */
    ReturnVO<String> delete(@PathVariable String name);

    /**
     * 删除所有的用户
     *
     * @return ResponseEntity
     */
    ReturnVO<String> deleteAll();

}
