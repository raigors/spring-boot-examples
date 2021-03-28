package com.github.spring.boot.kafka.config.consumer;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 数据转换或者统计
 * <p>
 * create in 2021/3/10 4:55 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class UserAuditLogConsumerRecordInterceptor implements RecordInterceptor<String, UserAuditLogDTO> {

    @Override
    public ConsumerRecord<String, UserAuditLogDTO> intercept(ConsumerRecord<String, UserAuditLogDTO> record) {
        record.value().setAccessDate(new Date());
        log.debug(record.value().toString());
        return record;
    }
}
