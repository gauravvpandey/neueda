package com.neueda.tinyurl.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;
import com.neueda.tinyurl.service.UrlService;

@RestController
@RequestMapping("/tinyurl")
public class UrlController {
	
	private UrlService urlService;

	@Autowired
	public UrlController(final UrlService urlService) {
		this.urlService = urlService;
	}
	
	@PostMapping("/create")
	public String createTinyurl(@RequestBody UrlRequest url) {
		//validate URL
		DomainUrl domainUrl = new DomainUrl(url.getNormalUrl(), url.getUser(), LocalDateTime.now());
		return urlService.createTinyurl(domainUrl);
	}

}
