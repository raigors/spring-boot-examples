package com.github.spring.boot.kafka.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 * <p>
 * create in 2021/3/10 4:22 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DirtiesContext
@SpringBootTest
@EmbeddedKafka(count = 3, ports = {9092, 9093, 9094}, controlledShutdown = true)
class DataConsumerControllerImplTest {

    @Value("${spring.embedded.kafka.brokers}")
    private String brokerAddresses;

    @Resource
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws Exception {
        Map<String, Object> senderProperties = KafkaTestUtils.producerProps(brokerAddresses);
        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(senderProperties);
        KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory);
        String topic = "test_topic";
        String message = objectMapper.writeValueAsString(getUserAuditLog());
        log.info(message);
        template.send(topic, message);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    void saveMessage() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("finish");
    }

    private UserAuditLogDTO getUserAuditLog() {
        return UserAuditLogDTO.builder()
                .username("test_username")
                .ip("test_ip").age(11)
                .userAgent("test_useragent")
                .message("test_message")
                .accessDate(new Date())
                .build();
    }

}