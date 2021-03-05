package com.github.spring.boot.elasticsearch.repository;

import com.github.spring.boot.elasticsearch.pojo.orm.FlowLogDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/4 10:17 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
class IFlowLogBasicRepositoryTest {

    @Resource
    private IFlowLogBasicRepository repository;

    @Test
    void findAllByConditions() {
        PageRequest request = PageRequest.of(0, 100);

//        for (UserInfoDO userInfoDO : repository.findAll(request)) {
//            System.out.println(userInfoDO.toString());
//        }

        for (FlowLogDO allByCondition : repository.findAllByConditions("{\"term\": {\"age\": 22}}", request)) {
            System.out.println(allByCondition.toString());
        }
    }
}