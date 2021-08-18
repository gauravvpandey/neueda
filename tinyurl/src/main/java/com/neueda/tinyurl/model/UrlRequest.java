package com.neueda.tinyurl.model;

public class UrlRequest {
	
	private String normalUrl;
	
	private String user;

	public String getNormalUrl() {
		return normalUrl;
	}

	public String getUser() {
		return user;
	}

	public UrlRequest(String normalUrl, String user) {
		super();
		this.normalUrl = normalUrl;
		this.user = user;
	} 

}
