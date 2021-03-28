package com.github.spring.boot.kafka.config.producer;

import com.github.spring.boot.kafka.deserializer.UserAuditLogDeserializer;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.Resource;
import java.util.Map;

/**
 * kafka 生产者相关的配置
 * <p>
 * create in 2021/3/23 9:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class KafkaProducerConfig {

    @Resource
    private KafkaAdmin kafkaAdmin;

    @Resource
    private KafkaProperties kafkaProperties;

    /**
     * @return 根据消费者设置 生成消费者工厂
     */
    @Bean
    public ProducerFactory<String, UserAuditLogDTO> consumerFactory() {
        Map<String, Object> map = Maps.newHashMap(kafkaProperties.buildProducerProperties());
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UserAuditLogDeserializer.class);
        return new DefaultKafkaProducerFactory<>(map);
    }


    @Bean
    public KafkaTemplate<String, UserAuditLogDTO> template(ProducerFactory<String, UserAuditLogDTO> producerFactory) {
        KafkaTemplate<String, UserAuditLogDTO> kafkaTemplate = new KafkaTemplate<>(producerFactory);
        return new KafkaTemplate<>(producerFactory);
    }


}
