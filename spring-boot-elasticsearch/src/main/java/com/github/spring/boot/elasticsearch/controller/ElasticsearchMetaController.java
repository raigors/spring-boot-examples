package com.github.spring.boot.elasticsearch.controller;

import com.github.spring.boot.elasticsearch.repository.IElasticsearchMetaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * es 元数据管理
 * <p>
 * create in 2021/2/24 9:13 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class ElasticsearchMetaController {

    @Resource
    private IElasticsearchMetaRepository repository;

    @DeleteMapping("/index/{name}")
    public boolean removeIndexByName(@PathVariable String name) {
        return repository.removeIndexByName(name);
    }

}
