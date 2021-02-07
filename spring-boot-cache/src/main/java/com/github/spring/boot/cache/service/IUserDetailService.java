package com.github.spring.boot.cache.service;

import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import com.github.spring.boot.cache.pojo.dto.UserQueryDTO;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 用户服务类接口
 * <p>
 * create in 2021/2/7 4:25 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserDetailService {

    /**
     * 查找满足条件的用户
     *
     * @param query    查询条件
     * @param pageable 分页信息
     * @return page
     */
    PageImpl<UserDetailDO> listUsers(UserQueryDTO query, Pageable pageable);

    /**
     * 新增用户
     *
     * @param userDetailDO 用户信息
     * @return UserDetailDO
     */
    UserDetailDO create(UserDetailDO userDetailDO);

    /**
     * 修改用户信息
     *
     * @param userDetailDO 用户信息
     * @return UserDetailDO
     */
    UserDetailDO update(UserDetailDO userDetailDO);

    /**
     * 根据用户名删除用户
     *
     * @param name 根据用户名删除用户
     * @return String
     */
    String delete(String name);

    /**
     * 删除所有的用户
     *
     * @return String
     */
    String deleteAll();

}
