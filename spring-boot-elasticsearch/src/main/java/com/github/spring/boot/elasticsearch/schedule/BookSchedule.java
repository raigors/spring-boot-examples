package com.github.spring.boot.elasticsearch.schedule;

import com.github.spring.boot.elasticsearch.repository.IFlowLogBasicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/2/22 3:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class BookSchedule {

    @Resource
    private IFlowLogBasicRepository repository;

    @Scheduled(fixedDelay = 1000L)
    public void task() {
    }

}
