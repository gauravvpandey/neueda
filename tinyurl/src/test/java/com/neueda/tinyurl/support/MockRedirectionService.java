package com.neueda.tinyurl.support;

import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.service.RedirectionService;

public class MockRedirectionService implements RedirectionService {

	public RedirectView view;
	public String tinyUrl;

	@Override
	public RedirectView redirect(String tinyUrl) {
		this.tinyUrl = tinyUrl;
		return view;
	}

}
