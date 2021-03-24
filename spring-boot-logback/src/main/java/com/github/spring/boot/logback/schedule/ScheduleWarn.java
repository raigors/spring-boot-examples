package com.github.spring.boot.logback.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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
public class ScheduleWarn {

    @Scheduled(fixedRate = 1500L)
    public void task() throws InterruptedException {
        while (true) {
            log.warn("warn");
            TimeUnit.SECONDS.sleep(10);
        }
    }

}
