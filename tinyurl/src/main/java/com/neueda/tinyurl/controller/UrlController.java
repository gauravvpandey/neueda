package com.neueda.tinyurl.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.config.RequestToDomainUrlFactory;
import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.service.RedirectionService;
import com.neueda.tinyurl.service.UrlService;
import com.neueda.tinyurl.utils.Constants;
import com.neueda.tinyurl.validation.Validator;

@RestController
@RequestMapping("/tinyurl")
public class UrlController {
	
	private final UrlService urlService;
	
	private final RedirectionService redirectionService;

	private final Validator<UrlRequest> validator;

	private RequestToDomainUrlFactory factory;
	
	@Autowired
	public UrlController(final UrlService urlService, 
			final RedirectionService redirectionService, 
			final Validator<UrlRequest> validator, 
			final RequestToDomainUrlFactory factory) {
		this.urlService = urlService;
		this.redirectionService = redirectionService;
		this.validator = validator;
		this.factory = factory;
	}
	
	@PostMapping("/create")
	public String createTinyurl(@RequestBody UrlRequest url) {
		validator.validate(url);
		return urlService.createTinyurl(factory.create(url));
	}
	
	@GetMapping("/{id}")
	public RedirectView redirect(@PathVariable String id) {
		//validate URL
		return redirectionService.redirect(id);
	}

}
