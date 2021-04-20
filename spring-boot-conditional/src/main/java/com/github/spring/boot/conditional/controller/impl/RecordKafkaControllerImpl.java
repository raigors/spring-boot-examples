package com.github.spring.boot.conditional.controller.impl;

import com.github.spring.boot.conditional.controller.IRecordController;
import com.github.spring.boot.conditional.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/4/9 5:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Controller
@ConditionalOnClass(KafkaTemplate.class)
public class RecordKafkaControllerImpl implements IRecordController {

    @KafkaListener(topics = "test_topic", groupId = "test_group", clientIdPrefix = "test_client_id_prefix", containerFactory = "kafkaListenerContainerFactory")
    @Override
    public void recordList(List<Person> list) {

    }
}
