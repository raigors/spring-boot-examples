package com.github.spring.boot.kafka.config;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RecordInterceptor;

import java.util.Date;

/**
 * TODO
 * <p>
 * create in 2021/3/10 4:55 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Component
public class UserAuditLogRecordInterceptor implements RecordInterceptor<String, UserAuditLogDTO> {

    @Override
    public ConsumerRecord<String, UserAuditLogDTO> intercept(ConsumerRecord<String, UserAuditLogDTO> record) {
        record.value().setAccessDate(new Date());
        log.error(record.value().toString());
        return record;
    }
}
