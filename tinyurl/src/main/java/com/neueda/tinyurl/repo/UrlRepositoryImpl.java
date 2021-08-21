package com.neueda.tinyurl.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.neueda.tinyurl.model.DomainUrl;

@Repository
public class UrlRepositoryImpl implements UrlRepository{
	
	private final RedisTemplate<String, DomainUrl> redisTemplate;
	
	@Autowired
	public UrlRepositoryImpl(final RedisTemplate<String, DomainUrl> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public void save(final String tinyUrl, final DomainUrl url) {
		redisTemplate.opsForValue().set(tinyUrl, url);
	}
	
	@Override
	public DomainUrl findByTinyurl(final String tinyUrl) {
		return redisTemplate.opsForValue().get(tinyUrl);
	}
}
