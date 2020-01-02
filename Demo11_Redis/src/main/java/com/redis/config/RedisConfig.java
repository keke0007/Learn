package com.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;


/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/9/24 15:12
 */
@Configuration
public class RedisConfig {
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//
//        Jackson2JsonRedisSerializer<Object> jacksonSeial = new Jackson2JsonRedisSerializer<Object>(Object.class);
//
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jacksonSeial.setObjectMapper(om);
//
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setValueSerializer(jacksonSeial);
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(jacksonSeial);
//
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
@Bean
public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);

    // 设置key的序列化方式
    template.setKeySerializer(RedisSerializer.string());
    // 设置value的序列化方式
    template.setValueSerializer(RedisSerializer.json());
    // 设置hash的key的序列化方式
    template.setHashKeySerializer(RedisSerializer.string());
    // 设置hash的value的序列化方式
    template.setHashValueSerializer(RedisSerializer.json());

    template.afterPropertiesSet();
    return template;
}
}
