package com.github.spring.boot.event.schedule;


import com.github.spring.boot.event.event.CommonEvent;
import com.github.spring.boot.event.pojo.DataBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午10:22 2019/12/8
 * 项目名称 spring-boot-event
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class CommonEventSchedule {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Scheduled(fixedDelay = 1000)
    public void eventSchedule() {
        System.out.println("------------CommonEventSchedule");
        eventPublisher.publishEvent(new CommonEvent(this, new DataBO(new Date().toString())));
    }

}
