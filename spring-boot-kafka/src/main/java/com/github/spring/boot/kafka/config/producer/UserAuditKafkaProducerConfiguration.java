package com.github.spring.boot.kafka.config.producer;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.converter.RecordMessageConverter;

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
public class UserAuditKafkaProducerConfiguration {

    @Resource
    private KafkaProperties properties;

    @Resource
    private ObjectProvider<UserAuditLogPartitioner> provider;

    @Resource
    private ObjectProvider<DefaultKafkaProducerFactoryCustomizer> customizers;

    @Bean
    public KafkaTemplate<String, UserAuditLogDTO> kafkaTemplateLog(ObjectProvider<ProducerListener<String, UserAuditLogDTO>> kafkaProducerListener,
                                                                   ObjectProvider<RecordMessageConverter> messageConverter) {
        KafkaTemplate<String, UserAuditLogDTO> kafkaTemplate = new KafkaTemplate<>(kafkaProducerFactoryLog());
        messageConverter.ifUnique(kafkaTemplate::setMessageConverter);
        kafkaProducerListener.ifAvailable(kafkaTemplate::setProducerListener);
        kafkaTemplate.setDefaultTopic(this.properties.getTemplate().getDefaultTopic());
        return kafkaTemplate;
    }

    @Bean
    public ProducerFactory<String, UserAuditLogDTO> kafkaProducerFactoryLog() {
        Map<String, Object> map = this.properties.buildProducerProperties();
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserAuditSerializer.class);
        provider.ifAvailable(partitioner -> map.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, partitioner.getClass()));
        DefaultKafkaProducerFactory<String, UserAuditLogDTO> factory = new DefaultKafkaProducerFactory<>(map);
        String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
        if (transactionIdPrefix != null) {
            factory.setTransactionIdPrefix(transactionIdPrefix);
        }
        customizers.orderedStream().forEach((customizer) -> customizer.customize(factory));
        return factory;
    }

}
