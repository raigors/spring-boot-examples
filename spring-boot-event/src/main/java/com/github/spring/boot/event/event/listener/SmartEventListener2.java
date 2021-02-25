package com.github.spring.boot.event.event.listener;


import com.github.spring.boot.event.event.SmartEvent;
import com.github.spring.boot.event.schedule.SmartEventSchedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 上午10:20 2019/12/8
 * 项目名称 spring-boot-event
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class SmartEventListener2 implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        // 只接收 SmartEvent 类型的事件,只有 SmartEvent 类型的事件才会执行下面的逻辑
        return aClass == SmartEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        SmartEvent smartEvent = (SmartEvent) applicationEvent;
        System.out.println("-----------SmartEvent-2-----------");
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        //只有在 SmartEventSchedule 内发布的 SmartEvent 事件时才会执行下面逻辑
        return sourceType == SmartEventSchedule.class;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
