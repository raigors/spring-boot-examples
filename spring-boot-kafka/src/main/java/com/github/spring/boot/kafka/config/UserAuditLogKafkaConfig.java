package com.github.spring.boot.kafka.config;

import com.github.spring.boot.kafka.deserializer.UserAuditLogDeserializer;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

import javax.annotation.Resource;
import java.util.Map;

/**
 * TODO
 * <p>
 * create in 2021/3/10 3:54 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Configuration
public class UserAuditLogKafkaConfig {

    @Resource
    private KafkaProperties kafkaProperties;

    /**
     * @return 根据消费者设置 生成消费者工厂
     */
    @Bean
    public ConsumerFactory<String, UserAuditLogDTO> consumerFactory() {
        Map<String, Object> map = Maps.newHashMap(kafkaProperties.buildConsumerProperties());
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UserAuditLogDeserializer.class);
//        map.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, property.getBatch());
//        map.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, property.getBatch());
        return new DefaultKafkaConsumerFactory<>(map);
    }

    /**
     * @return ConcurrentKafkaListenerContainerFactory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserAuditLogDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, UserAuditLogDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(10);
        // enable batch listening
        factory.setBatchListener(true);
        filterStrategyObjectProvider.ifAvailable(factory::setRecordFilterStrategy);
        recordInterceptorObjectProvider.ifAvailable(factory::setRecordInterceptor);
        return factory;
    }

    @Resource
    private ObjectProvider<RecordFilterStrategy<String, UserAuditLogDTO>> filterStrategyObjectProvider;

    @Resource
    private ObjectProvider<RecordInterceptor<String, UserAuditLogDTO>> recordInterceptorObjectProvider;

}
