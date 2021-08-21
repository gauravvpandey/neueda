package com.neueda.tinyurl.model;

public class UrlRequest {
	
	public UrlRequest(final String normalUrl, final String user) {
		super();
		this.normalUrl = normalUrl;
		this.user = user;
	} 

	private final String normalUrl;
	
	private final String user;

	public String getNormalUrl() {
		return normalUrl;
	}

	public String getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		return "UrlRequest [normalUrl=" + normalUrl + ", user=" + user + "]";
	}

}
