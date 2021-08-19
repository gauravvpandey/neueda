package com.neueda.tinyurl.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neueda.tinyurl.factory.RequestToDomainUrlFactoryImpl;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;

class RequestToDomainUrlFactoryImplTest {

	private RequestToDomainUrlFactoryImpl domainUrlFactoryImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		domainUrlFactoryImpl = new RequestToDomainUrlFactoryImpl();
	}

	@Test
	void test() {
		UrlRequest urlRequest = new UrlRequest("http://gaurav.com", "gaurav");
		DomainUrl domainUrl = domainUrlFactoryImpl.create(urlRequest);
		assertEquals(urlRequest.getNormalUrl(), domainUrl.getNormalUrl());
		assertEquals(urlRequest.getUser(), domainUrl.getUser());
		assertNotNull(domainUrl.getDateTime());
		assertTrue(LocalDateTime.now().isAfter(domainUrl.getDateTime()));
	}

}
