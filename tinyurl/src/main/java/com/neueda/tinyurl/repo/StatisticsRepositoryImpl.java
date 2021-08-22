package com.neueda.tinyurl.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.neueda.tinyurl.utils.Constants;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository{
	
	private final RedisTemplate<String, Integer> redisTemplate;

	@Autowired
	public StatisticsRepositoryImpl(final RedisTemplate<String, Integer> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public void userRequestStatistics(final String user) {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		if(!hashOperations.putIfAbsent(Constants.USER_REQUEST_STATS, user, 1)) {
			hashOperations.increment(Constants.USER_REQUEST_STATS, user, 1);
		}
	}
	
	@Override
	public void tinyUrlRedirectionStatistics(final String tinyUrl) {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		if(!hashOperations.putIfAbsent(Constants.TINY_URL_REDIRECTION_STATS, tinyUrl, 1)) {
			hashOperations.increment(Constants.TINY_URL_REDIRECTION_STATS, tinyUrl, 1);
		}
	}

	@Override
	public Map<String, Integer> getUserRequestStatistics() {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		final Map<String, Integer> entries = hashOperations.entries(Constants.USER_REQUEST_STATS);
		return entries;
	}
	
	@Override
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		final HashOperations<String, String, Integer> hashOperations = redisTemplate.opsForHash();
		final Map<String, Integer> entries = hashOperations.entries(Constants.TINY_URL_REDIRECTION_STATS);
		return entries;
	}
}
