package com.github.spring.boot.rest.template.manager;

import com.github.spring.boot.rest.template.pojo.dto.UserInfoDTO;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/5 5:25 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootTest
@AutoConfigureWireMock(stubs = "classpath:/mapping", port = 8088)
class RemoteManagerTest {

    @Resource
    private RemoteManager manager;

    private static final String USERNAME = "shishaodong";

    @Test
    void remote() {
        UserInfoDTO user = manager.remote("http://127.0.0.1:8088/api/remote", Lists.newArrayList("123"));
        System.out.println(user);
        Assertions.assertEquals(user.getUsername(), USERNAME);
    }
}