package com.github.spring.boot.kafka.schedule;

import com.github.javafaker.Faker;
import com.github.spring.boot.kafka.pojo.UserAuditLogDTO;
import com.github.spring.boot.kafka.service.UserProducerCallbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 定时任务
 * <p>
 * create in 2021/4/20 7:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class ScheduleTask {

    private static final Faker FAKER = new Faker(new Locale("zh-CN"));

    @Resource
    private UserProducerCallbackService producerService;

    @Scheduled(fixedDelay = 1000)
    public void task() {
        producerService.dispatchCommonMessage(userAuditLog());
    }

    private UserAuditLogDTO userAuditLog() {
        return UserAuditLogDTO.builder()
                .username(FAKER.funnyName().name())
                .ip(FAKER.internet().ipV4Address())
                .build();
    }


}
