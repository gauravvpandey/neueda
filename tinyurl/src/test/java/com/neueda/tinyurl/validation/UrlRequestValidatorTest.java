package com.neueda.tinyurl.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.neueda.tinyurl.config.TinyurlConfig;
import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.utils.Constants;

class UrlRequestValidatorTest {
	
	private UrlRequestValidator validator;
	
	private TinyurlConfig config;

	@BeforeEach
	void setUp() throws Exception {
		config = new TinyurlConfig(null, null);
		validator = new UrlRequestValidator(config.urlValidator());
	}

	@Test
	void testValidateValidURL_HTTP() {
		UrlRequest request = new UrlRequest("http://gauravlabs.com", "gaurav");
		assertTrue(validator.validate(request));
	}
	
	@Test
	void testValidateValidURL_HTTPS() {
		UrlRequest request = new UrlRequest("https://gauravlabs.com", "gaurav");
		assertTrue(validator.validate(request));
	}
	
	@Test
	void testValidateInValidURL() {
		UrlRequest request = new UrlRequest("ssh://gauravlabs.com", "gaurav");
		final ValidationFailedException exception = assertThrows(ValidationFailedException.class, () -> {
			validator.validate(request);
		});
		assertEquals(exception.getStatus(), HttpStatus.BAD_REQUEST);
		assertEquals(exception.getMessage(), Constants.INVALID_URL);
	}

}
