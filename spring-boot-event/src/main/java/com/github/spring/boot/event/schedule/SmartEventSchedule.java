package com.github.spring.boot.event.schedule;


import com.github.spring.boot.event.event.SmartEvent;
import com.github.spring.boot.event.pojo.DataBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
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
public class SmartEventSchedule {

    @Resource
    private ApplicationContext applicationContext;

    @Scheduled(fixedDelay = 3000)
    public void eventSchedule() {
        applicationContext.publishEvent(new SmartEvent(this, new DataBO(new Date().toString())));
    }

}
