package com.github.spring.boot.elasticsearch.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/3 4:13 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IElasticsearchAggregationRepositoryTest {

    @Resource
    private ElasticsearchRestTemplate template;

    @Test
    void aggregation() {
        NativeSearchQueryBuilder groupQuery = new NativeSearchQueryBuilder();


    }


}
