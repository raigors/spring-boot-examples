package com.github.spring.boot.elasticsearch.repository;

import com.github.spring.boot.elasticsearch.pojo.orm.BookDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * TODO
 * <p>
 * create in 2021/2/18 4:16 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IBookRepository extends ElasticsearchRepository<BookDO, String> {

    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

    BookDO existsByNameEquals(String name);

}