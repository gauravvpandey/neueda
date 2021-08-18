package com.neueda.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.model.DomainUrl;

@Service
public class RedirectionServiceImpl implements RedirectionService{
	
	private RedisTemplate<String, DomainUrl> redisTemplate;
	
	@Autowired
	public RedirectionServiceImpl(RedisTemplate<String, DomainUrl> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public RedirectView redirect(String tinyUrl) {
		final DomainUrl domainUrl = redisTemplate.opsForValue().get(tinyUrl);
		if(domainUrl == null) {
			throw new RuntimeException("No url found");
		}
		return new RedirectView(domainUrl.getNormalUrl(), true);
		//return "redirect:" + domainUrl.getNormalUrl();
	}

}
