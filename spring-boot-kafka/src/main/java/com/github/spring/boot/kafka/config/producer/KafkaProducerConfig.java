package com.github.spring.boot.kafka.config.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaAdmin;

import javax.annotation.Resource;

/**
 * kafka 生产者相关的配置
 * <p>
 * create in 2021/3/23 9:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Configuration
public class KafkaProducerConfig {

    @Resource
    private KafkaAdmin kafkaAdmin;

    @Resource
    private KafkaProperties kafkaProperties;


}
