package com.github.spring.boot.mongodb.repository;

import com.github.spring.boot.mongodb.pojo.UserResumeDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserResumeBasicRepository extends PagingAndSortingRepository<UserResumeDO, String> {

    boolean existsByUsernameEquals(String username);

}
