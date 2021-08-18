package com.neueda.tinyurl.service;

import com.neueda.tinyurl.model.DomainUrl;

public interface UrlService {

	String createTinyurl(DomainUrl normalUrl);

	String getNormalUrl(String tinyUrl);

}
