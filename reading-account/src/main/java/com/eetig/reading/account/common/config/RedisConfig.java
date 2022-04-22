package com.eetig.reading.account.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;


import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @Date 2022/4/22 周五 17:23
 * @Author xu
 * @FileName RedisConfig
 * @Description
 */
@EnableCaching
@Configuration
public class RedisConfig {
    /**
     * @param redisConnectionFactory
     * @Date 2022/4/22 17:36
     * @Author eetig
     * @Description 配置redis对象
     * @Return org.springframework.data.redis.core.RedisTemplate
     **/
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        this.setSerializer(redis);
        return redis;
    }

    /**
     * @param
     * @Date 2022/4/22 17:42
     * @Author eetig
     * @Description 配置key的生成方式
     * @Return org.springframework.cache.interceptor.KeyGenerator
     **/
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(o.getClass().getName()).append(method.getName());
                for (Object object : objects) {
                    stringBuffer.append(object.toString());
                }
                return stringBuffer.toString();
            }
        };
    }
    /**
     * @Date 2022/4/22 17:55
     * @Author eetig
     * @Description 缓存管理器
     * @param redisConnectionFactory
     * @Return org.springframework.cache.CacheManager
     **/
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //1. 初始化redis写对象
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //2. 设置管理器的序列化方式为json
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        //3. 设置过期时间 30s
        RedisCacheConfiguration defaultCacheConfig = redisCacheConfiguration.entryTtl(Duration.ofSeconds(300));
        //4. 初始化rediscachemanager
        return  new RedisCacheManager(redisCacheWriter,defaultCacheConfig);
    }

    /**
     * @Date 2022/4/22 17:56
     * @Author eetig
     * @Description 设置redistemplate序列化方式
     * @param redisTemplate
     * @Return void
     **/
    private void setSerializer(RedisTemplate redisTemplate) {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // 设置key 的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // 设置value 的序列化方式
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();

    }

}
