package com.github.spring.boot.elasticsearch.repository;

import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * TODO
 * <p>
 * create in 2021/2/18 4:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IFlowLogBasicRepository extends ElasticsearchRepository<FlowLogDO, String> {

    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

    FlowLogDO existsByUsernameEquals(String name);

    @Query("?0")
    Page<FlowLogDO> findAllByConditions(String query, Pageable pageable);

}