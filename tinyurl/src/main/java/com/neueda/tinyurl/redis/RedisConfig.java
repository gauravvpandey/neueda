package com.neueda.tinyurl.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.tinyurl.model.DomainUrl;

@Configuration
public class RedisConfig {

  @Autowired
  ObjectMapper mapper;

  @Autowired
  RedisConnectionFactory connectionFactory;

  @Bean
  RedisTemplate<String, DomainUrl> redisTemplate() {
    final RedisTemplate<String, DomainUrl> redisTemplate = new RedisTemplate<>();
    final Jackson2JsonRedisSerializer<DomainUrl> valueSerializer = new Jackson2JsonRedisSerializer<>(DomainUrl.class);
    valueSerializer.setObjectMapper(mapper);
    redisTemplate.setConnectionFactory(connectionFactory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(valueSerializer);
    return redisTemplate;
  }
}