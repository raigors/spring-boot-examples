package com.github.spring.boot.cache.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

/**
 * TODO
 * <p>
 * create in 2021/2/7 11:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class CachePropertiesConfig {

    @Bean
    public CacheProperties cacheProperties() {
        return new CacheProperties();
    }

    @Bean
    public CacheManagerCustomizers cacheManagerCustomizers(@NotNull ObjectProvider<CacheManagerCustomizer<?>> customizers) {
        return new CacheManagerCustomizers(customizers.orderedStream().collect(Collectors.toList()));
    }

}
