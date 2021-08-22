package com.neueda.tinyurl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.tinyurl.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	private final StatisticsService statisticsService;

	@Autowired
	public StatisticsController(final StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	@GetMapping("/users")
	public Map<String, Integer> getUserRequestStatistics() {
		return statisticsService.getUserRequestStatistics();
	}
	
	@GetMapping("/redirections")
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		return statisticsService.getTinyUrlRedirectionStatistics();
	}
}
