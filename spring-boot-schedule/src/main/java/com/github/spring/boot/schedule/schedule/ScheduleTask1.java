package com.github.spring.boot.schedule.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 创建时间为 下午3:44 2020/1/13
 * 项目名称 spring-boot-schedule
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class ScheduleTask1 {

    @Scheduled(fixedRate = 1500L)
    public void task() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "  " + new Date() + ":ScheduleTask1");
        TimeUnit.SECONDS.sleep(10);
    }
}
