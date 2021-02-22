package com.github.spring.boot.elasticsearch.init;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.github.spring.boot.elasticsearch.pojo.orm.BookDO;
import com.github.spring.boot.elasticsearch.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/2/19 11:11 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class InitBooksRunner implements CommandLineRunner {

    @Resource
    private IBookRepository repository;

    @Override
    public void run(String... args) {
//        repository.deleteAll();
        Faker faker = new Faker(Locale.CHINESE);
        for (int i = 0; i < 22; i++) {
            Book fakeBook = faker.book();
            BookDO book = BookDO.builder().name(fakeBook.title()).desc(fakeBook.title()).build();
            repository.save(book);
            log.info("保存数据:{}", book.toString());
        }
    }
}
