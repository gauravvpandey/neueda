package com.neueda.tinyurl.model;

import java.time.LocalDateTime;

public class DomainUrl {
	
	private String normalUrl;
	
	private String user;
	
	private LocalDateTime dateTime;
	
	public DomainUrl(String normalUrl, String user, LocalDateTime dateTime) {
		super();
		this.normalUrl = normalUrl;
		this.user = user;
		this.dateTime = dateTime;
	}

	public String getNormalUrl() {
		return normalUrl;
	}

	public String getUser() {
		return user;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	@Override
	public String toString() {
		return "DomainUrl [normalUrl=" + normalUrl + ", user=" + user + ", dateTime=" + dateTime + "]";
	}

}
