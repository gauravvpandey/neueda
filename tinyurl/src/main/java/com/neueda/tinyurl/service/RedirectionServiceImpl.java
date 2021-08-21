package com.neueda.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.exceptions.ValidationFailedException;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;
import com.neueda.tinyurl.utils.Constants;

@Service
public class RedirectionServiceImpl implements RedirectionService{
	
	private UrlRepository repo;
	
	@Autowired
	public RedirectionServiceImpl(UrlRepository repo) {
		this.repo = repo;
	}
	
	public RedirectView redirect(String tinyUrl) {
		final DomainUrl domainUrl = repo.findByTinyurl(tinyUrl);
		if(domainUrl == null) {
			throw new ValidationFailedException(HttpStatus.BAD_REQUEST, Constants.NOT_FOUND);
		}
		final RedirectView redirectView = new RedirectView(domainUrl.getNormalUrl(), true);
		return redirectView;
	}

}
