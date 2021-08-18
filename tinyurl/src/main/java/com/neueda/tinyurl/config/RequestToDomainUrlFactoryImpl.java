package com.neueda.tinyurl.config;

import java.time.LocalDateTime;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;

public class RequestToDomainUrlFactoryImpl {
	
	public DomainUrl create(UrlRequest request) {
		return new DomainUrl(request.getNormalUrl(), request.getUser(), LocalDateTime.now());
	}

}
