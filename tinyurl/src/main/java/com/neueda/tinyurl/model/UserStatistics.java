package com.neueda.tinyurl.model;

public class UserStatistics {
	
	private final String user;
	
	private final Integer count;
	
	public UserStatistics(final String user, final Integer count) {
		super();
		this.user = user;
		this.count = count;
	}

	public String getUser() {
		return user;
	}

	public Integer getCount() {
		return count;
	}

}
