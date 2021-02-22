package com.github.spring.boot.elasticsearch.repository.impl;

import com.github.spring.boot.elasticsearch.repository.IElasticsearchMetaRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:18 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Repository
public class ElasticsearchMetaRepositoryImpl implements IElasticsearchMetaRepository {

//    @Resource
//    private IndexOperations indexOperations;

    @Resource
    private ElasticsearchRestTemplate restTemplate;

    public void listAllIndices(){
//        restTemplate.
//        indexOperations.
    }

}
