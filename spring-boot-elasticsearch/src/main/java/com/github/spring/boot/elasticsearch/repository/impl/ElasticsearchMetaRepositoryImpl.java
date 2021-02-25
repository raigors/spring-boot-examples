package com.github.spring.boot.elasticsearch.repository.impl;

import com.github.spring.boot.elasticsearch.pojo.orm.UserInfoDO;
import com.github.spring.boot.elasticsearch.repository.IElasticsearchMetaRepository;
import com.google.common.collect.Lists;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchScrollHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

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

    @Resource
    private RestHighLevelClient client;

    @Resource
    private ElasticsearchRestTemplate template;

    @Override
    public List<String> findAllIndices() {
        String[] indexNames = template.indexOps(UserInfoDO.class).getIndexCoordinates().getIndexNames();
        return Lists.newArrayList(indexNames);
    }

    @Override
    public boolean removeIndexByName(String indexName) {
        return template.indexOps(IndexCoordinates.of(indexName)).delete();
    }

    public void listAllIndices() {
        IndexCoordinates index = IndexCoordinates.of("sample-index");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withFields("message")
                .withPageable(PageRequest.of(0, 10))
                .build();

        SearchScrollHits<UserInfoDO> searchHits = template.searchScrollStart(1000, searchQuery, UserInfoDO.class, index);

//        String scrollId = searchHits.getScrollId();
//        List<BookDO> samples = Lists.newArrayList();
//        while (searchHits.hasSearchHits()) {
//            samples.addAll(searchHits.getSearchHits());
//            scrollId = searchHits.getScrollId();
//            searchHits = template.searchScrollContinue(scrollId, 1000, BookDO.class);
//        }
//        template.searchScrollClear(scrollId);
    }

}
