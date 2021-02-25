package com.github.spring.boot.event.event.listener;


import com.github.spring.boot.event.event.CommonEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 创建时间为 上午10:18 2019/12/8
 * 项目名称 spring-boot-event
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class CommonEventListener {

    @Order(3)
//    @Async
    @SneakyThrows
    @EventListener
    public void listener1(CommonEvent event) {
        System.out.println("-----------CommonEvent-1-----------");
        TimeUnit.SECONDS.sleep(1);
    }

    @Order(2)
//    @Async
    @SneakyThrows
    @EventListener
    public void listener2(CommonEvent event) {
        System.out.println("-----------CommonEvent-2-----------");
        TimeUnit.SECONDS.sleep(1);
    }

    @Order(1)
//    @Async
    @SneakyThrows
    @EventListener
    public void listener3(CommonEvent event) {
        System.out.println("-----------CommonEvent-3-----------");
        TimeUnit.SECONDS.sleep(1);
    }
//    ServletRequestHandledEvent

    @Order(1)
//    @Async
    @SneakyThrows
    @EventListener
    public void listener4(ApplicationStartedEvent event) {
        System.out.println("-----------ApplicationStartedEvent-3-----------");
        TimeUnit.SECONDS.sleep(1);
    }

}

