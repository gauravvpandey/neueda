package com.neueda.tinyurl.factory;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.model.UrlRequest;

public interface RequestToDomainUrlFactory {

	DomainUrl create(final UrlRequest request);

}
