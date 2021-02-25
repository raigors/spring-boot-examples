package com.github.spring.boot.elasticsearch.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/23 3:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IElasticsearchMetaRepositoryTest {

    @Resource
    private IElasticsearchMetaRepository repository;

    @Test
    void findAllIndices() {
        for (String index : repository.findAllIndices()) {
            System.out.println(index);
        }
    }

    @Test
    void removeIndexByName() {
        repository.removeIndexByName("2021-02-22_15_30");
    }
}