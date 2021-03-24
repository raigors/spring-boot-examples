package com.github.spring.boot.logback.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TODO
 * <p>
 * create in 2021/3/22 2:34 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class MajorService {

    @Scheduled(fixedRate = 1000L)
    public void major() {
        log.warn("major warn");
        log.debug("major debug");
        log.info("major info");
    }

}
