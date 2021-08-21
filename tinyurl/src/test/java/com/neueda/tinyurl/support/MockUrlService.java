package com.neueda.tinyurl.support;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.service.UrlService;

public class MockUrlService implements UrlService {

	public String tinyUrl;

	@Override
	public String createTinyurl(DomainUrl normalUrl) {
		return tinyUrl;
	}
}
