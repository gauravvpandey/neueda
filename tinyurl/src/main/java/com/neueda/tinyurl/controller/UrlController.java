package com.neueda.tinyurl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.factory.RequestToDomainUrlFactory;
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

	private final RequestToDomainUrlFactory factory;
	
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
	public String createTinyurl(@RequestBody final UrlRequest url) {
		validator.validate(url);
		String tinyurl = urlService.createTinyurl(factory.create(url));
		return Constants.TINY_URL+tinyurl;
	}
	
	@GetMapping("/{id}")
	public RedirectView redirect(@PathVariable final String id) {
		return redirectionService.redirect(id);
	}
	
}
