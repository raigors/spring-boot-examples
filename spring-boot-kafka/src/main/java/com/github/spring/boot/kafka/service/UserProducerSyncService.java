package com.github.spring.boot.kafka.service;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 * <p>
 * create in 2021/4/20 3:06 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service
public class UserProducerSyncService {

    @Resource(name = "kafkaTemplateLog")
    private KafkaTemplate<String, UserAuditLogDTO> template;

    @SneakyThrows({InterruptedException.class, ExecutionException.class, TimeoutException.class})
    public void dispatchCommonMessage(UserAuditLogDTO message) {
        ProducerRecord<String, UserAuditLogDTO> auditLog = new ProducerRecord<>("test_UserAuditLog", message);
        SendResult<String, UserAuditLogDTO> result = template.send(auditLog).get(10, TimeUnit.SECONDS);
        log.info(result.toString());
    }

}
