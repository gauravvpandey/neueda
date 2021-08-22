package com.neueda.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;
import com.neueda.tinyurl.utils.HashingUtils;

@Service
public class UrlServiceImpl implements UrlService {
	
	private final UrlRepository repo;
	
	@Autowired
	public UrlServiceImpl(final UrlRepository repo) {
		this.repo = repo;
	}
	
	
	public String createTinyurl(final DomainUrl url) {
		final String tinyUrl = HashingUtils.hashValue(url.getNormalUrl());
		repo.save(tinyUrl, url);
		return tinyUrl;
	}
	
}
