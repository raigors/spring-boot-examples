package com.github.spring.boot.kafka.service;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/20 3:29 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DirtiesContext
@SpringBootTest
@ActiveProfiles("junit")
@EmbeddedKafka(count = 3, ports = {9092, 9093, 9094}, partitions = 6, controlledShutdown = true)
class UserProducerCallbackServiceTest {

    @Resource
    private UserProducerCallbackService service;

    @Test
    void dispatchCommonMessage() {
        service.dispatchCommonMessage(getUserAuditLog());
    }

    private UserAuditLogDTO getUserAuditLog() {
        return UserAuditLogDTO.builder()
                .username("test_name")
                .ip("2.3.4.5")
                .build();
    }

}