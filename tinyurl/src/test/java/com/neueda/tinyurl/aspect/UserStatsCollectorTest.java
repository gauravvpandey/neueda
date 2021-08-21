package com.neueda.tinyurl.aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.support.MockStatisticsRepository;

class UserStatsCollectorTest {
	
	private UserStatsCollector userStatsCollector;
	private MockStatisticsRepository repo;

	@BeforeEach
	void setUp(){
		repo = new MockStatisticsRepository();
		userStatsCollector = new UserStatsCollector(repo);
	}

	@Test
	void test() {
		String user = "gaurav";
		DomainUrl domainUrl = new DomainUrl("https://gauravlabs.com", user, null);
		userStatsCollector.afterCreateTinyurl(null, domainUrl , null);
		assertEquals(user, repo.user);
	}

}
