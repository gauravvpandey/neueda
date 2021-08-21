package com.neueda.tinyurl.support;

import java.util.Map;

import com.neueda.tinyurl.repo.StatisticsRepository;

public class MockStatisticsRepository implements StatisticsRepository {

	public String user;
	public String tinyUrl;

	@Override
	public void userRequestStatistics(String user) {
		this.user = user;
	}

	@Override
	public void tinyUrlRedirectionStatistics(String tinyUrl) {
		this.tinyUrl = tinyUrl;
	}

	@Override
	public Map<String, Integer> getUserRequestStatistics() {
		return null;
	}

	@Override
	public Map<String, Integer> getTinyUrlRedirectionStatistics() {
		return null;
	}

}
