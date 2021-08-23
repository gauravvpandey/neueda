package com.neueda.tinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;
import com.neueda.tinyurl.utils.HashingStrategy;
import com.neueda.tinyurl.utils.Murmur32HashingStrategy;

class UrlServiceImplTest {
	
	private UrlServiceImpl urlServiceImpl;
	private UrlRepository repo;
	private HashingStrategy hashingStrategy;

	@BeforeEach
	void setUp(){
		hashingStrategy = new Murmur32HashingStrategy();
		repo = mock(UrlRepository.class);
		urlServiceImpl = new UrlServiceImpl(repo, hashingStrategy);
	}

	@Test
	void test() {
		DomainUrl domainUrl = new DomainUrl("http://gauravlabs.com", "gaurav", LocalDateTime.now());
		String tinyurl = urlServiceImpl.createTinyurl(domainUrl );
		assertEquals(hashingStrategy.hashValue(domainUrl.getNormalUrl()), tinyurl);
	}

}
