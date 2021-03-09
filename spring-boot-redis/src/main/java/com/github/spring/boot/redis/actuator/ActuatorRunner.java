package com.github.spring.boot.redis.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * TODO
 * <p>
 * create in 2021/3/8 3:27 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class ActuatorRunner implements CommandLineRunner {

    @Resource
    private Map<String, AbstractHealthIndicator> indicators;

    @Override
    public void run(String... args) {
        indicators.keySet().forEach(log::info);
    }
}
