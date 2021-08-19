package com.neueda.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.utils.Constants;

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
			throw new ValidationFailedException(HttpStatus.BAD_REQUEST, Constants.NOT_FOUND);
		}
		return new RedirectView(domainUrl.getNormalUrl(), true);
	}

}
