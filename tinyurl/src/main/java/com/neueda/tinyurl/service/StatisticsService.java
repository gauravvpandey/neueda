package com.neueda.tinyurl.service;

import java.util.Map;

public interface StatisticsService {

	Map<String, Integer> getUserRequestStatistics();

	Map<String, Integer> getTinyUrlRedirectionStatistics();

}
