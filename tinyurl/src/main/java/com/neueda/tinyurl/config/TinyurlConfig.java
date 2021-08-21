package com.neueda.tinyurl.config;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.tinyurl.factory.RequestToDomainUrlFactory;
import com.neueda.tinyurl.factory.RequestToDomainUrlFactoryImpl;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.validation.UrlRequestValidator;
import com.neueda.tinyurl.validation.Validator;

@Configuration
public class TinyurlConfig {

	private ObjectMapper mapper;

	private RedisConnectionFactory connectionFactory;

	@Autowired
	public TinyurlConfig(final ObjectMapper mapper, final RedisConnectionFactory connectionFactory) {
		this.mapper = mapper;
		this.connectionFactory = connectionFactory;
	}

	@Bean
	public RedisTemplate<String, DomainUrl> redisTemplate() {
		final RedisTemplate<String, DomainUrl> redisTemplate = new RedisTemplate<>();
		final Jackson2JsonRedisSerializer<DomainUrl> valueSerializer = new Jackson2JsonRedisSerializer<>(
				DomainUrl.class);
		valueSerializer.setObjectMapper(mapper);
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(RedisSerializer.string());
		redisTemplate.setValueSerializer(valueSerializer);
		redisTemplate.setHashKeySerializer(RedisSerializer.string());
		redisTemplate.setHashValueSerializer(valueSerializer);
		return redisTemplate;
	}
	
	@Bean
	public RedisTemplate<String, Integer> redisTemplateStatistics() {
		final RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
//		final Jackson2JsonRedisSerializer<Integer> valueSerializer = new Jackson2JsonRedisSerializer<>(
//				Integer.class);
//		valueSerializer.setObjectMapper(mapper);
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(RedisSerializer.string());
		redisTemplate.setValueSerializer(RedisSerializer.json());
		redisTemplate.setHashKeySerializer(RedisSerializer.string());
		redisTemplate.setHashValueSerializer(RedisSerializer.json());
		return redisTemplate;
	}

	@Bean
	public UrlValidator urlValidator() {
		final String[] schemes = { "http", "https" };
		return new UrlValidator(schemes);
	}

	@Bean
	public Validator<UrlRequest> getValidator(UrlValidator urlValidator) {
		return new UrlRequestValidator(urlValidator);
	}

	@Bean
	RequestToDomainUrlFactory getFactory() {
		return new RequestToDomainUrlFactoryImpl();
	}

}