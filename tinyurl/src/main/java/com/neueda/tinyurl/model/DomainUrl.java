package com.neueda.tinyurl.model;

import java.time.LocalDateTime;

public class DomainUrl {
	
	private final String normalUrl;
	
	private final String user;
	
	private final LocalDateTime dateTime;
	
	public DomainUrl(final String normalUrl, final String user, final LocalDateTime dateTime) {
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
