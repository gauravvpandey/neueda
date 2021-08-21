package com.neueda.tinyurl.service;

import org.springframework.data.redis.core.RedisTemplate;

import com.neueda.tinyurl.model.DomainUrl;

public class StatisticsServiceImpl implements StatisticsService{
	
	private RedisTemplate<String, DomainUrl> redisTemplate;
	
	public StatisticsServiceImpl(RedisTemplate<String, DomainUrl> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void userStats() {
		//redisTemplate.opsForValue().getOperations().
	}
	
	
	//re direction per tiny url

}
