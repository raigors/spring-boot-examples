package com.github.spring.boot.kafka.service;

import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/3/15 10:27 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
//@Service
public class DataProducerService {

    @Resource(name = "kafkaTemplate")
    private KafkaTemplate<String, String> template;

    @Transactional(rollbackFor = Exception.class)
    public String dispatchTransactionalMessage(UserAuditLogDTO message) {
        template.send("test_topic", message.toString());
        if (StringUtils.contains(message.getMessage(), "error")) {
            log.info("error:{}", 10 / 0);
        }
        template.send("test_topic", message.toString());
        return "SUCCESS";
    }

}
