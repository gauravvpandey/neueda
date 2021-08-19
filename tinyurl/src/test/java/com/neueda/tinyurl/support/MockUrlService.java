package com.neueda.tinyurl.support;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.service.UrlService;

public class MockUrlService implements UrlService {

	public String tinyUrl;
	public String normalUrl;

	@Override
	public String createTinyurl(DomainUrl normalUrl) {
		return tinyUrl;
	}

	@Override
	public String getNormalUrl(String tinyUrl) {
		return normalUrl;
	}

}
