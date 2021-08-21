package com.neueda.tinyurl.repo;

import java.util.Map;

public interface StatisticsRepository {

	void userRequestStatistics(String user);

	void tinyUrlRedirectionStatistics(String tinyUrl);

	Map<String, Integer> getUserRequestStatistics();

	Map<String, Integer> getTinyUrlRedirectionStatistics();

}
