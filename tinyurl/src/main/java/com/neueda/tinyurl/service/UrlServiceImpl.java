package com.neueda.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;
import com.neueda.tinyurl.utils.HashingStrategy;

@Service
public class UrlServiceImpl implements UrlService {
	
	private final UrlRepository repo;
	private HashingStrategy hashingStrategy;
	
	@Autowired
	public UrlServiceImpl(final UrlRepository repo, final HashingStrategy hashingStrategy) {
		this.repo = repo;
		this.hashingStrategy = hashingStrategy;
	}
	
	
	public String createTinyurl(final DomainUrl url) {
		final String tinyUrl = hashingStrategy.hashValue(url.getNormalUrl());
		repo.save(tinyUrl, url);
		return tinyUrl;
	}
	
}
