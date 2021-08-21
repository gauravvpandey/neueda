package com.neueda.tinyurl.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UrlRequestTest {
	
	private UrlRequest request;
	private String normalUrl;
	private String user;

	@BeforeEach
	void setUp() throws Exception {
		normalUrl = "https://gauravlabs.com";
		user = "gaurav";
		request = new UrlRequest(normalUrl, user);
	}

	@Test
	void test() {
		assertEquals(normalUrl, request.getNormalUrl());
		assertEquals(user, request.getUser());
	}

}
