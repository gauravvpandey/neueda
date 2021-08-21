package com.neueda.tinyurl.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository{
	
	private static final String TINY_URL_REDIRECTION_STATS = "TINY_URL_REDIRECTION_STATS";
	private static final String USER_REQUEST_STATS = "USER_REQUEST_STATS";
	private final RedisTemplate<String, Integer> redisTemplate;

	@Autowired
	public StatisticsRepositoryImpl(final RedisTemplate<String, Integer> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public void userRequestStatistics(String user) {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		if(!hashOperations.putIfAbsent(USER_REQUEST_STATS, user, 1)) {
			hashOperations.increment(USER_REQUEST_STATS, user, 1);
		}
	}
	
	@Override
	public void tinyUrlRedirectionStatistics(String tinyUrl) {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		if(!hashOperations.putIfAbsent(TINY_URL_REDIRECTION_STATS, tinyUrl, 1)) {
			hashOperations.increment(TINY_URL_REDIRECTION_STATS, tinyUrl, 1);
		}
	}

	@Override
	public Map<String, Integer> getUserRequestStatistics() {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		final Map<String, Integer> entries = hashOperations.entries(USER_REQUEST_STATS);
		return entries;
	}
	
	@Override
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		final Map<String, Integer> entries = hashOperations.entries(TINY_URL_REDIRECTION_STATS);
		return entries;
	}
}
