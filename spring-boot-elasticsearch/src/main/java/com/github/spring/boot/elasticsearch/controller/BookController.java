package com.github.spring.boot.elasticsearch.controller;

import com.github.spring.boot.elasticsearch.pojo.orm.BookDO;
import com.github.spring.boot.elasticsearch.pojo.vo.BookVO;
import com.github.spring.boot.elasticsearch.repository.IBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/19 11:08 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@RestController
public class BookController {

    @Resource
    private IBookRepository repository;

    @GetMapping("/books")
    public Page<BookVO> listBooks(@PageableDefault(page = 1) Pageable pageable) {
        return repository.findAllBy(pageable, BookVO.class);
    }

    @GetMapping("/book/{name}")
    public BookDO existsByName(@PathVariable String name) {
        return repository.existsByNameEquals(name);
    }

}
