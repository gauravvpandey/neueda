package com.neueda.tinyurl.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.neueda.tinyurl.model.DomainUrl;

class UrlRepositoryImplTest {

	private UrlRepositoryImpl urlRepositoryImpl;
	private RedisTemplate<String, DomainUrl> template;
	private ValueOperations<String, DomainUrl> valueOps;
	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() throws Exception {
		valueOps = spy(ValueOperations.class);
		template = mock(RedisTemplate.class);
		urlRepositoryImpl = new UrlRepositoryImpl(template);
	}

	@Test
	void testSaveAndFindByTinyurl() {
		String tinyUrl = "ajgdkjAD";
		DomainUrl domainUrl = new DomainUrl("http://gauravlabs.com", "gaurav", LocalDateTime.now());
		doReturn(domainUrl).when(valueOps).get(tinyUrl);
		when(template.opsForValue()).thenReturn(valueOps);
		urlRepositoryImpl.save(tinyUrl, domainUrl);
		assertEquals(urlRepositoryImpl.findByTinyurl(tinyUrl),domainUrl); 
	}

}
