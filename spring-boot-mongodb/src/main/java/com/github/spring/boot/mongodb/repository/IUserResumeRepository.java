package com.github.spring.boot.mongodb.repository;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:14 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserResumeRepository<V, Q> {

    List<V> findAllByQueryConditions(Q q);

}
