package com.github.spring.boot.kafka.service;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

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
public class UserProducerCallbackService {

    @Resource(name = "kafkaTemplateLog")
    private KafkaTemplate<String, UserAuditLogDTO> template;

    public void dispatchCommonMessage(UserAuditLogDTO message) {
        ProducerRecord<String, UserAuditLogDTO> auditLog = new ProducerRecord<>("test_UserAuditLog", message);
        ListenableFuture<SendResult<String, UserAuditLogDTO>> userAuditLog = template.send(auditLog);
        userAuditLog.addCallback(new DataFutureCallback());
    }

    static class DataFutureCallback implements ListenableFutureCallback<SendResult<String, UserAuditLogDTO>> {

        @Override
        public void onFailure(@NotNull Throwable throwable) {
            log.warn("发送失败:{}", ExceptionUtils.getMessage(throwable));
        }

        @Override
        public void onSuccess(SendResult<String, UserAuditLogDTO> sendResult) {
            if (ObjectUtils.isNotEmpty(sendResult)) {
                log.info("发送成功:{}", sendResult);
            }
        }
    }
}
