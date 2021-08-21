package com.neueda.tinyurl.service;

import java.util.Map;

import com.neueda.tinyurl.repo.StatisticsRepository;

public class StatisticsServiceImpl implements StatisticsService{
	
	private final StatisticsRepository statisticsRepository;
	
	public StatisticsServiceImpl(final StatisticsRepository statisticsRepository) {
		this.statisticsRepository = statisticsRepository;
	}
	
	@Override
	public Map<String, Integer> getUserRequestStatistics() {
		return statisticsRepository.getUserRequestStatistics();
	}

	@Override
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		return statisticsRepository.getTinyUrlRedirectionStatistics();
	}

}
