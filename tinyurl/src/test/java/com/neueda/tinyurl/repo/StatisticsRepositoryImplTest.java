package com.neueda.tinyurl.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.neueda.tinyurl.utils.Constants;

class StatisticsRepositoryImplTest {
	
	private StatisticsRepository statisticsRepository;
	private RedisTemplate<String, Integer> template;
	private HashOperations<String, Object, Object> hash;
	private Map<Object, Object> map;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp(){
		map = new HashMap<>();
		hash = mock(HashOperations.class);
		template= mock(RedisTemplate.class);
		statisticsRepository = new StatisticsRepositoryImpl(template);
	}

	@Test
	void testUserRequestStatisticsAndGetUserRequestStatistics() {
		map.put("gaurav", 1);
		when(hash.entries(Constants.USER_REQUEST_STATS)).thenReturn(map);
		when(hash.putIfAbsent(Constants.USER_REQUEST_STATS, "gaurav", 1)).thenReturn(true);
		when(template.opsForHash()).thenReturn(hash);
		statisticsRepository.userRequestStatistics("gaurav");
		assertEquals(statisticsRepository.getUserRequestStatistics(), map);
	}
	
	@Test
	void testUserRequestStatisticsAndGetUserRequestStatisticsUserAlreadyPresent() {
		map.put("gaurav", 2);
		when(hash.entries(Constants.USER_REQUEST_STATS)).thenReturn(map);
		when(hash.putIfAbsent(Constants.USER_REQUEST_STATS, "gaurav", 2)).thenReturn(false);
		when(template.opsForHash()).thenReturn(hash);
		statisticsRepository.userRequestStatistics("gaurav");
		assertEquals(statisticsRepository.getUserRequestStatistics(), map);
	}
	
	@Test
	void testTinyUrlRedirectionStatisticsAndGetTinyUrlRedirectionStatistics() {
		map.put("http://gauravlabs.com", 2);
		when(hash.entries(Constants.TINY_URL_REDIRECTION_STATS)).thenReturn(map);
		when(hash.putIfAbsent(Constants.TINY_URL_REDIRECTION_STATS, "http://gauravlabs.com", 2)).thenReturn(true);
		when(template.opsForHash()).thenReturn(hash);
		statisticsRepository.tinyUrlRedirectionStatistics("http://gauravlabs.com");
		assertEquals(statisticsRepository.getTinyUrlRedirectionStatistics(), map);
	}

	@Test
	void testTinyUrlRedirectionStatisticsAndGetTinyUrlRedirectionStatisticsAndUrlAlreadyExists() {
		map.put("http://gauravlabs.com", 2);
		when(hash.entries(Constants.TINY_URL_REDIRECTION_STATS)).thenReturn(map);
		when(hash.putIfAbsent(Constants.TINY_URL_REDIRECTION_STATS, "http://gauravlabs.com", 2)).thenReturn(false);
		when(template.opsForHash()).thenReturn(hash);
		statisticsRepository.tinyUrlRedirectionStatistics("http://gauravlabs.com");
		assertEquals(statisticsRepository.getTinyUrlRedirectionStatistics(), map);
	}
}
