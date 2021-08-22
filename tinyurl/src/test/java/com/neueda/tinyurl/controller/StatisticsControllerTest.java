package com.neueda.tinyurl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.service.StatisticsService;

class StatisticsControllerTest {
	
	private StatisticsController statisticsController;
	private StatisticsService statsService;

	@BeforeEach
	void setUp() {
		statsService = mock(StatisticsService.class);
		statisticsController = new StatisticsController(statsService);
	}

	@Test
	void testGetTinyUrlRedirectionStatistics() {
		Map<String, Integer> redirectionStats = new HashMap<>();
		redirectionStats.put("http://gauravlabs.com", 10);
		when(statsService.getTinyUrlRedirectionStatistics()).thenReturn(redirectionStats );
		assertEquals(redirectionStats, statisticsController.getTinyUrlRedirectionStatistics());
	}
	
	@Test
	void testGetUserRequestStatistics() {
		Map<String, Integer> userStats = new HashMap<>();
		userStats.put("gaurav", 10);
		when(statsService.getUserRequestStatistics()).thenReturn(userStats );
		assertEquals(userStats, statisticsController.getUserRequestStatistics());
	}

}
