package com.tt.common.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis.config
 * @version:
 */
@Configuration
public class RedisConfig {

    /**
     * 创建RedisTemplate
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,Object>setRedisTemplate(RedisConnectionFactory factory){
        // 创建RedisTemplate
        RedisTemplate <String,Object>redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        // 设置序列化器
        // 创建Redis中的Value的序列化器
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 默认开启类型
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 创建Redis中的key的序列化器
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // 设置Redis中的String类型的value序列化器
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // 设置Redis中的hash类型的value序列化器
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        // 设置Redis中的String类型的key序列化器
        redisTemplate.setKeySerializer(stringRedisSerializer);

        // 设置Redis中的hash类型的key序列化器
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }




}
