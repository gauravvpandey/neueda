package com.neueda.tinyurl.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.tinyurl.repo.StatisticsRepository;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	
	private final StatisticsRepository statisticsRepository;
	
	@Autowired
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
