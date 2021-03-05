package com.github.spring.boot.elasticsearch.repository;

import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

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

    @Resource
    private RestHighLevelClient client;

    @Resource
    private ElasticsearchRestTemplate template;

    @Test
    void findAllIndices() {
        for (String index : repository.findAllIndices()) {
            System.out.println(index);
        }
    }

    @Test
    void query() {
        IndexCoordinates index = IndexCoordinates.of("index_2020-03-01", "index_2020-03-02", "index_2020-03-03");
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "age");
//        QueryBuilder builder = QueryBuilders.wildcardQuery("username", "a*");
//        QueryBuilders.rangeQuery("age").gte(50);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.rangeQuery("age").gte(50))
                .withFields("username", "age")
                .withPageable(pageable)
                .build();
        SearchHits<FlowLogDO> searchHits = template.search(searchQuery, FlowLogDO.class, index);
        searchHits.getSearchHits().forEach(userInfoDOSearchHit -> System.out.println(userInfoDOSearchHit.getContent().toString()));
    }

}