package com.github.spring.boot.cache.config;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 缓存 key 生成器
 * <p>
 * create in 2021/2/7 10:46 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Configuration
public class UserDetailKeyGeneratorConfig {

    /**
     * 创建默认
     *
     * @return KeyGenerator
     */
    @Bean("DefaultGenerator")
    public KeyGenerator defaultGenerator() {
        log.info("创建 DefaultGenerator!");
        return (target, method, params) -> Arrays.asList(params).toString();
    }


    /**
     * 创建默认
     *
     * @return KeyGenerator
     */
    @Bean("RedisGenerator")
    public KeyGenerator redisGenerator() {
        log.info("创建 DefaultGenerator!");
        return (target, method, params) -> Joiner.on(":").skipNulls().join(params);
    }


    /**
     * UserKeyGenerator
     *
     * @return KeyGenerator
     */
    @Bean("UserKeyGenerator")
    public KeyGenerator keyGenerator() {
        log.info("创建 UserKeyGenerator!");
        return (target, method, params) -> method.getName() + ":" + Arrays.asList(params).toString();
    }

}
