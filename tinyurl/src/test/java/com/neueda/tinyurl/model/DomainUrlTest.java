package com.neueda.tinyurl.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DomainUrlTest {
	
	private DomainUrl domainUrl;
	private String normalUrl;
	private String user;
	private LocalDateTime time;

	@BeforeEach
	void setUp() throws Exception {
		normalUrl = "https://gauravlabs.com";
		user = "gaurav";
		time = LocalDateTime.now();
		domainUrl = new DomainUrl(normalUrl, user, time);
	}

	@Test
	void test() {
		assertEquals(normalUrl, domainUrl.getNormalUrl());
		assertEquals(user, domainUrl.getUser());
		assertEquals(time, domainUrl.getDateTime());
	}

}
