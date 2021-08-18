package com.neueda.tinyurl.service;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.neueda.tinyurl.model.DomainUrl;

@Service
public class UrlServiceImpl implements UrlService {
	
	private RedisTemplate<String, DomainUrl> redisTemplate;
	
	@Autowired
	public UrlServiceImpl(RedisTemplate<String, DomainUrl> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	
	public String createTinyurl(DomainUrl url) {
		final String id = Hashing.murmur3_32().hashString(url.getNormalUrl(), Charset.defaultCharset()).toString();
		redisTemplate.opsForValue().set(id, url);
		return id;
	}
	
	public String getNormalUrl(String tinyUrl) {
		DomainUrl normalUrl = redisTemplate.opsForValue().get(tinyUrl);
		if(normalUrl == null) {
			throw new RuntimeException("No url found");
		}
		return normalUrl.getNormalUrl();
		
	}
	
}
