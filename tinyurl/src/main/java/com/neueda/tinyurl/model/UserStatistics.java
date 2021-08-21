package com.neueda.tinyurl.model;

public class UserStatistics {
	
	private String user;
	
	private Integer count;
	
	public UserStatistics(String user, Integer count) {
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
