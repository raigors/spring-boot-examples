package com.github.spring.boot.cache.config;

import com.github.spring.boot.cache.pojo.entity.UserDetailDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/2/7 11:09 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class RedisCacheManagerJsonConfig {

    @Bean("JsonCacheManager")
    public RedisCacheManager cacheManager(CacheProperties cacheProperties, CacheManagerCustomizers cacheManagerCustomizers,
                                          ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration,
                                          ObjectProvider<RedisCacheManagerBuilderCustomizer> redisCacheManagerBuilderCustomizers,
                                          RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(
                determineConfiguration(cacheProperties, redisCacheConfiguration));
        List<String> cacheNames = cacheProperties.getCacheNames();
        if (!cacheNames.isEmpty()) {
            builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
        }
        redisCacheManagerBuilderCustomizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
        return cacheManagerCustomizers.customize(builder.build());
    }

    private RedisCacheConfiguration determineConfiguration(CacheProperties cacheProperties,
                                                           @NotNull ObjectProvider<RedisCacheConfiguration> redisCacheConfiguration) {
        return redisCacheConfiguration.getIfAvailable(() -> createConfiguration(cacheProperties));
    }

    private RedisCacheConfiguration createConfiguration(@NotNull CacheProperties cacheProperties) {
        Redis redisProperties = cacheProperties.getRedis();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        config = config.serializeValuesWith(SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<>(UserDetailDO.class)));
        if (redisProperties.getTimeToLive() != null) {
            config = config.entryTtl(redisProperties.getTimeToLive());
        }
        if (redisProperties.getKeyPrefix() != null) {
            config = config.prefixCacheNameWith(redisProperties.getKeyPrefix());
        }
        if (!redisProperties.isCacheNullValues()) {
            config = config.disableCachingNullValues();
        }
        if (!redisProperties.isUseKeyPrefix()) {
            config = config.disableKeyPrefix();
        }
        return config;
    }


}
