package com.wcx.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author chenxin
 * @create 2022-03-21 16:40
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //java存进redis，需要序列化
        //设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
        //设置普通value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        //设置value中hash的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        //设置value中hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet();
        return template;
    }
}
