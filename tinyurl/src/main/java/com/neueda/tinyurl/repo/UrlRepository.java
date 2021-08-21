package com.neueda.tinyurl.repo;

import com.neueda.tinyurl.model.DomainUrl;

public interface UrlRepository {

	void save(String tinyUrl, DomainUrl url);

	DomainUrl findByTinyurl(String tinyUrl);

}
