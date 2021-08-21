package com.neueda.tinyurl.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.support.MockStatisticsRepository;
import com.neueda.tinyurl.utils.Constants;

class RedirectionStatsCollectorTest {

	private RedirectionStatsCollector redirectionServiceAspect;
	private MockStatisticsRepository repo;
	
	@BeforeEach
	void setUp() {
		repo = new MockStatisticsRepository();
		redirectionServiceAspect = new RedirectionStatsCollector(repo);
	}

	@Test
	void test() {
		String tinyUrl = "asasdgh";
		redirectionServiceAspect.afterCreateTinyurl(null, tinyUrl, null);
		assertEquals(Constants.TINY_URL+tinyUrl, repo.tinyUrl);
	}

}
