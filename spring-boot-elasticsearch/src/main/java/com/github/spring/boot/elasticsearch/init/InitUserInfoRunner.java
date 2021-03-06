package com.github.spring.boot.elasticsearch.init;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.github.spring.boot.elasticsearch.pojo.bo.BookBO;
import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import com.github.spring.boot.elasticsearch.repository.IFlowLogBasicRepository;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

/**
 * 初始化数据
 * <p>
 * create in 2021/2/19 11:11 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
//@Component
public class InitUserInfoRunner implements CommandLineRunner {

    @Resource
    private IFlowLogBasicRepository repository;

    private static final int USER = 200;

    private static final Faker FAKER = new Faker(Locale.CHINESE);

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            for (int i = 0; i < USER; i++) {
                FlowLogDO user = generateUser();
                repository.save(user);
                log.info("保存数据:{} - {}", i, user.toString());
            }
        }
    }

    private FlowLogDO generateUser() {
        return FlowLogDO.builder()
                .username(getUsername())
                .age(getAge())
                .programmingLanguages(getProgrammingLanguages())
                .phoneNumber(getPhoneNumber())
                .books(getBooks()).createDate(DateTime.now().minusDays(0).toDate())
                .build();
    }

    private String getUsername() {
        return FAKER.name().username();
    }

    private int getAge() {
        return FAKER.number().numberBetween(0, 60);
    }

    private List<String> getProgrammingLanguages() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < FAKER.number().numberBetween(1, 4); i++) {
            list.add(FAKER.programmingLanguage().name());
        }
        return list;
    }

    private String getPhoneNumber() {
        return FAKER.phoneNumber().cellPhone();
    }

    private List<BookBO> getBooks() {
        List<BookBO> list = Lists.newArrayList();
        for (int i = 0; i < FAKER.number().numberBetween(1, 6); i++) {
            Book book = FAKER.book();
            list.add(BookBO.builder()
                    .author(book.author())
                    .title(book.title())
                    .publisher(book.publisher())
                    .genre(book.genre())
                    .build());
        }
        return list;
    }

}
