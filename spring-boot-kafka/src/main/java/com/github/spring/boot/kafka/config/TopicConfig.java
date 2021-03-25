package com.github.spring.boot.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * 配置 Kafka 主题
 * <p>
 * create in 2021/3/24 5:33 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class TopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
