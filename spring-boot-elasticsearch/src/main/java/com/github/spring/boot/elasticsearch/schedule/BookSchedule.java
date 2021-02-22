package com.github.spring.boot.elasticsearch.schedule;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.github.spring.boot.elasticsearch.pojo.orm.BookDO;
import com.github.spring.boot.elasticsearch.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class BookSchedule {

    @Resource
    private IBookRepository repository;

    @Scheduled(fixedDelay = 1000L)
    public void task() {
        Faker faker = new Faker(Locale.CHINESE);
        Book fakeBook = faker.book();
        BookDO book = BookDO.builder().name(fakeBook.title()).desc(fakeBook.title()).build();
        repository.save(book);
        log.info("保存数据:{}", book.toString());
    }

}
