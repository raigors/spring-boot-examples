package com.github.spring.boot.event.event;

import com.github.spring.boot.event.pojo.DataBO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * <p>
 * 创建时间为 上午10:17 2019/12/8
 * 项目名称 spring-boot-event
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class CommonEvent extends ApplicationEvent {

    private static final long serialVersionUID = 6694932872503560843L;

    @Getter
    private DataBO data;

    public CommonEvent(Object source, DataBO data) {
        super(source);
        this.data = data;
    }
}
