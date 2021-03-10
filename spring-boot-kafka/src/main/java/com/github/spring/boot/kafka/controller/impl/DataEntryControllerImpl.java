package com.github.spring.boot.kafka.controller.impl;

import com.github.spring.boot.kafka.controller.IDataEntryController;
import com.github.spring.boot.kafka.pojo.ResultVO;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/3/10 3:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class DataEntryControllerImpl implements IDataEntryController {

    @Override
    public ResultVO<Void> saveMessage(UserAuditLogDTO message) {
        return null;
    }

    @KafkaListener(topics = "test_topic", groupId = "test_group", clientIdPrefix = "test_client_id_prefix", containerFactory = "kafkaListenerContainerFactory")
    @Override
    public ResultVO<Void> saveAllMessage(List<UserAuditLogDTO> list) {
        log.error(list.toString());
        return null;
    }
}
