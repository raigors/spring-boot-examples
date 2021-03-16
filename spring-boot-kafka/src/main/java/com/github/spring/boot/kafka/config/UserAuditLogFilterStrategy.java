package com.github.spring.boot.kafka.config;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

/**
 * TODO
 * <p>
 * create in 2021/3/10 4:54 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Component
public class UserAuditLogFilterStrategy implements RecordFilterStrategy<String, UserAuditLogDTO> {

    @Override
    public boolean filter(ConsumerRecord<String, UserAuditLogDTO> consumerRecord) {
        log.error(consumerRecord.value().toString());
        return consumerRecord.value().getAge() > 18;
    }
}
