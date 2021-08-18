package com.neueda.tinyurl.config;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;

public interface RequestToDomainUrlFactory {

	DomainUrl create(UrlRequest request);

}
