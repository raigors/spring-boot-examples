package com.github.spring.boot.redis.config;

import com.github.spring.boot.redis.pojo.UserDO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO
 * <p>
 * create in 2021/2/8 9:58 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Configuration
public class RedisTemplateConfig {

    /**
     * 使用 Jackson 方式序列化对象
     * <p>
     * ((LettuceConnectionFactory)factory).setDatabase(1)
     *
     * @return RedisTemplate
     */
    @Bean("RedisTemplateFastJson")
    public RedisTemplate<String, UserDO> getRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, UserDO> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(UserDO.class));
        template.afterPropertiesSet();
        return template;
    }

}
