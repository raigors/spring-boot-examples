package com.github.spring.boot.cache.service.impl;

import com.github.spring.boot.cache.pojo.dto.UserQueryDTO;
import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import com.github.spring.boot.cache.repository.IUserDetailRepository;
import com.github.spring.boot.cache.service.IUserDetailService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * 用户服务类实现
 * <p>
 * create in 2021/2/7 4:25 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "user-cache", cacheManager = "JsonCacheManager", keyGenerator = "DefaultGenerator")
public class UserDetailServiceImpl implements IUserDetailService {

    private final IUserDetailRepository repository;

    @Override
    public PageImpl<UserDetailDO> listUsers(UserQueryDTO query, Pageable pageable) {
        return repository.findAll(getSpecification(query), pageable);
    }

    @Cacheable
    @Override
    public UserDetailDO findByName(String name) {
        UserDetailDO user = repository.findByName(name);
        log.info("UserDetailDO - findByName:{} - {}", name, user);
        return user;
    }

    @Cacheable
    @Override
    public UserDetailDO findByPhone(String phone) {
        UserDetailDO user = repository.findByPhone(phone);
        log.info("UserDetailDO - findByPhone:{} - {}", phone, user);
        return user;
    }

    @Caching(
            cacheable = {
                    @Cacheable(key = "'[' + #a0.name + ']' "),
            },
            put = {
                    @CachePut(key = "'[' + #result.name + ']'"),
                    @CachePut(key = "'[' + #result.phone + ']'")
            }
    )
    @Override
    public UserDetailDO create(UserDetailDO userDetailDO) {
        return repository.save(userDetailDO);
    }

    @Override
    public UserDetailDO update(UserDetailDO userDetailDO) {
        return repository.save(userDetailDO);
    }

    @CacheEvict(key = "'[' + #a0 + ']'")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String delete(String name) {
        return repository.deleteByName(name) + "";
    }

    @CacheEvict(allEntries = true)
    @Override
    public String deleteAll() {
        repository.deleteAll();
        return "success";
    }

    private Specification<UserDetailDO> getSpecification(UserQueryDTO queryCond) {
        return (root, query, builder) -> {
            List<Predicate> list = Lists.newArrayList();
            if (StringUtils.isNoneBlank(queryCond.getName())) {
                Predicate predicateParent = builder.like(root.get("name").as(String.class), queryCond.getName());
                list.add(predicateParent);
            }
            if (StringUtils.isNoneBlank(queryCond.getPhone())) {
                Predicate predicateParent = builder.like(root.get("phone").as(String.class), queryCond.getPhone());
                list.add(predicateParent);
            }
            if (ObjectUtils.isNotEmpty(queryCond.getAge())) {
                Predicate predicateParent = builder.equal(root.get("age").as(Integer.class), queryCond.getAge());
                list.add(predicateParent);
            }
            Predicate[] predicates = list.toArray(new Predicate[0]);
            return query.where(predicates).getRestriction();
        };
    }
}
