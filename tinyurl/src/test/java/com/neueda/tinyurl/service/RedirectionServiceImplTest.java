package com.neueda.tinyurl.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;

import com.neueda.tinyurl.model.DomainUrl;

class RedirectionServiceImplTest {
	
	private RedirectionServiceImpl redirectionServiceImpl;
	private RedisTemplate<String, DomainUrl> template;

	@BeforeEach
	void setUp() throws Exception {
		redirectionServiceImpl = new RedirectionServiceImpl(template);
	}


	void test() {
		fail("Not yet implemented");
	}

}
