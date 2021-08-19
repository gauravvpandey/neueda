package com.neueda.tinyurl.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.factory.RequestToDomainUrlFactory;
import com.neueda.tinyurl.factory.RequestToDomainUrlFactoryImpl;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.support.MockRedirectionService;
import com.neueda.tinyurl.support.MockUrlService;
import com.neueda.tinyurl.support.MockValidator;
import com.neueda.tinyurl.utils.Constants;

class UrlControllerTest {
	
	private UrlController urlController;
	private MockUrlService urlService;
	private MockRedirectionService redirectionService;
	private MockValidator validator;
	private RequestToDomainUrlFactory factory;

	@BeforeEach
	void setUp() throws Exception {
		urlService = new MockUrlService();
		redirectionService = new MockRedirectionService();
		validator = new MockValidator();
		factory = new RequestToDomainUrlFactoryImpl();
		urlController = new UrlController(urlService, redirectionService, validator, factory);
	}

	@Test
	void testCreateTinyurlInValidUrl() {
		validator.valid = false;
		UrlRequest urlRequest = new UrlRequest("ftp://gaurav.com", "gaurav");
		final ValidationFailedException exception = assertThrows(ValidationFailedException.class, () -> {
			urlController.createTinyurl(urlRequest );
		});
		assertEquals(exception.getStatus(), HttpStatus.BAD_REQUEST);
		assertEquals(exception.getMessage(), Constants.INVALID_URL);
	}
	
	@Test
	void testCreateTinyurlValidUrl() {
		validator.valid = true;
		urlService.tinyUrl = "hgfusdhf";
		UrlRequest urlRequest = new UrlRequest("https://gaurav.com", "gaurav");
		assertEquals(urlService.tinyUrl, urlController.createTinyurl(urlRequest));
	}

	@Test
	void testRedirect() {
		redirectionService.view = new RedirectView();
		String id = "hsgfiusfg";
		RedirectView redirect = urlController.redirect(id);
		assertEquals(redirectionService.view, redirect);
		assertEquals(redirectionService.tinyUrl, id);
	}
	
	
}
