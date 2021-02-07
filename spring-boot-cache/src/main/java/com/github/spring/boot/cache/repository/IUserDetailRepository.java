package com.github.spring.boot.cache.repository;

import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * JPA 接口
 * <p>
 * create in 2021/2/7 4:22 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserDetailRepository extends PagingAndSortingRepository<UserDetailDO, Long>, JpaSpecificationExecutor<UserDetailDO> {

    /**
     * 根据用户名删除用户
     *
     * @param name 用户名
     * @return 删除的个数
     */
    int deleteByName(String name);

    /**
     * 分页查找所有的用户信息
     *
     * @param var1 查找条件
     * @param var2 分页参数
     * @return PageImpl
     */
    @Override
    PageImpl<UserDetailDO> findAll(Specification<UserDetailDO> var1, Pageable var2);

    /**
     * 判断用户名或者手机号码是否存在
     *
     * @param name  用户名
     * @param phone 手机号码
     * @return boolean
     */
    boolean existsByNameOrPhone(String name, String phone);


}
