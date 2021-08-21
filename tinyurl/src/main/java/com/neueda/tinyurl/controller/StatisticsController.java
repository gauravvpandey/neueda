package com.neueda.tinyurl.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.tinyurl.repo.StatisticsRepository;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	private StatisticsRepository statisticsRepository;

	public StatisticsController(StatisticsRepository statisticsRepository) {
		this.statisticsRepository = statisticsRepository;
	}

	@GetMapping("/users")
	public Map<String, Integer> getUserRequestStatistics() {
		return statisticsRepository.getUserRequestStatistics();
	}
	
	@GetMapping("/redirections")
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		return statisticsRepository.getTinyUrlRedirectionStatistics();
	}
}
