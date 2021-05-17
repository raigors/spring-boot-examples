package com.github.spring.boot.mongodb.repository;

import com.github.spring.boot.mongodb.pojo.UserResumeQueryDTO;
import com.github.spring.boot.mongodb.pojo.UserResumeResultDTO;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/28 4:46 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IUserResumeRepositoryTest {

    @Resource
    private IUserResumeRepository<UserResumeResultDTO, UserResumeQueryDTO> repository;

    @Test
    void findAllByQueryConditions() {
        List<UserResumeResultDTO> all = repository.findAllByQueryConditions(new UserResumeQueryDTO(DateTime.now().minusDays(100).toDate(), new Date()));
        all.forEach(System.out::println);
    }
}