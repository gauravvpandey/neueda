package com.neueda.tinyurl.model;

public class UrlRequest {
	
	public UrlRequest(String normalUrl, String user) {
		super();
		this.normalUrl = normalUrl;
		this.user = user;
	} 

	private String normalUrl;
	
	private String user;

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
