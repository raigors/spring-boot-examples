package com.github.spring.boot.kafka.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

/**
 * TODO
 * <p>
 * create in 2021/3/15 10:37 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DirtiesContext
@SpringBootTest
@EmbeddedKafka(count = 3, ports = {9092, 9093, 9094}, controlledShutdown = true)
class DataProducerControllerImplTest {

    @Test
    void dispatchMessage1() {
    }

    @Test
    void dispatchMessage2() {
    }
}