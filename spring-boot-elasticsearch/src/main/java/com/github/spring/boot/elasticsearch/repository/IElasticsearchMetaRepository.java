package com.github.spring.boot.elasticsearch.repository;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IElasticsearchMetaRepository {

    List<String> findAllIndices();

    boolean removeIndexByName(String indexName);


}
