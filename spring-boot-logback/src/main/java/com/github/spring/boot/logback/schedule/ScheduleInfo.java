package com.github.spring.boot.logback.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TODO
 * <p>
 * create in 2021/3/8 3:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class ScheduleInfo {

    @Scheduled(fixedRate = 1500L)
    public void task() throws InterruptedException {
        log.info("info");
//        TimeUnit.SECONDS.sleep(10);
    }

}