package com.neueda.tinyurl.service;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.UrlRepository;

@Service
public class UrlServiceImpl implements UrlService {
	
	private UrlRepository repo;
	
	@Autowired
	public UrlServiceImpl(UrlRepository repo) {
		this.repo = repo;
	}
	
	
	public String createTinyurl(DomainUrl url) {
		final String tinyUrl = Hashing.murmur3_32().hashString(url.getNormalUrl(), Charset.defaultCharset()).toString();
		repo.save(tinyUrl, url);
		return tinyUrl;
	}
	
}
