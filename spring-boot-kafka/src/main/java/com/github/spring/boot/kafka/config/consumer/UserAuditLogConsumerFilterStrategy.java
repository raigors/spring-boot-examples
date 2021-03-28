package com.github.spring.boot.kafka.config.consumer;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.stereotype.Component;

/**
 * 过滤数据 只有返回 false 的数据才会被保留
 * age 为空的数据或者 age < 18  才会被保留
 *
 * <p>
 * create in 2021/3/10 4:54 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class UserAuditLogConsumerFilterStrategy implements RecordFilterStrategy<String, UserAuditLogDTO> {

    @Override
    public boolean filter(ConsumerRecord<String, UserAuditLogDTO> consumerRecord) {
        log.debug(consumerRecord.value().toString());
        Integer age = consumerRecord.value().getAge();
        if (age == null) {
            return false;
        }
        return age > 18;
    }
}
