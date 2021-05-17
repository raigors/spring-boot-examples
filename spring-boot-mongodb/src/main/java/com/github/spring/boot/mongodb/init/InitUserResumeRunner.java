package com.github.spring.boot.mongodb.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.mongodb.pojo.UserResumeDO;
import com.github.spring.boot.mongodb.repository.IUserResumeBasicRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Locale;

/**
 * 初始化数据
 * <p>
 * create in 2021/4/28 4:23 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class InitUserResumeRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker(Locale.ENGLISH);

    private static final int NUM = 1000;

    @Resource
    private IUserResumeBasicRepository repository;

    @Override
    public void run(String... args) {
        while (repository.count() < NUM) {
            UserResumeDO resume = getUserResume();
            if (!repository.existsByUsernameEquals(resume.getUsername())) {
                repository.save(resume);
                log.info("保存数据:{}", resume);
            }
        }
    }

    private UserResumeDO getUserResume() {
        return UserResumeDO.builder()
                .username(FAKER.name().username())
                .mobile(FAKER.phoneNumber().cellPhone())
                .age(RandomUtils.nextInt(15, 30))
                .email(FAKER.internet().emailAddress())
                .region(FAKER.hobbit().location())
                .createdDate(FAKER.date().between(DateTime.now().minusYears(5).toDate(), new Date()))
                .build();
    }

}
