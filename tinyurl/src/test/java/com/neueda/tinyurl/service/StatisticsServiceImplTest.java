package com.neueda.tinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.repo.StatisticsRepository;

class StatisticsServiceImplTest {
	
	private StatisticsServiceImpl statisticsServiceImpl;
	private StatisticsRepository repo;
	private Map<String, Integer> map;

	@BeforeEach
	void setUp() {
		map = new HashMap<>();
		repo = mock(StatisticsRepository.class);
		statisticsServiceImpl = new StatisticsServiceImpl(repo);
	}

	@Test
	void testGetTinyUrlRedirectionStatistics() {
		when(repo.getTinyUrlRedirectionStatistics()).thenReturn(map);
		assertEquals(statisticsServiceImpl.getTinyUrlRedirectionStatistics(), map);
	}

	@Test
	void testGetUserRequestStatistics() {
		when(repo.getUserRequestStatistics()).thenReturn(map);
		assertEquals(statisticsServiceImpl.getUserRequestStatistics(), map);
	}
}
