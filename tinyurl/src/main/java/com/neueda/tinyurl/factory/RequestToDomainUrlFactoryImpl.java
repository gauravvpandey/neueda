package com.neueda.tinyurl.factory;

import java.time.LocalDateTime;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;

public class RequestToDomainUrlFactoryImpl implements RequestToDomainUrlFactory{
	
	public DomainUrl create(final UrlRequest request) {
		return new DomainUrl(request.getNormalUrl(), request.getUser(), LocalDateTime.now());
	}

}
