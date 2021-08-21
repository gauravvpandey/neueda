package com.neueda.tinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;
import com.neueda.tinyurl.utils.Constants;

class RedirectionServiceImplTest {
	
	private RedirectionServiceImpl redirectionServiceImpl;
	private UrlRepository urlRepository;

	@BeforeEach
	void setUp() {
		urlRepository = Mockito.mock(UrlRepository.class);
		redirectionServiceImpl = new RedirectionServiceImpl(urlRepository);
	}


	@Test
	void testRedirectWhenUrlFound() {
		final String normalUrl = "http://gaurav.com";
		final DomainUrl domainUrl = new DomainUrl(normalUrl, "gaurav", LocalDateTime.now());
		when(urlRepository.findByTinyurl("sdfdhdjf")).thenReturn(domainUrl);
		RedirectView view = redirectionServiceImpl.redirect("sdfdhdjf");
		assertEquals(view.getUrl(), normalUrl);
	}

	@Test
	void testRedirectWhenUrlNotFound() {
		final ValidationFailedException exception = assertThrows(ValidationFailedException.class, () -> {
			redirectionServiceImpl.redirect("sdfdhdjf");
		});
		assertEquals(exception.getStatus(), HttpStatus.BAD_REQUEST);
		assertEquals(exception.getMessage(), Constants.NOT_FOUND);
	}
}
