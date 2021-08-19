package com.neueda.tinyurl.service;

import org.springframework.web.servlet.view.RedirectView;

public interface RedirectionService {

	RedirectView redirect(String tinyUrl);

}
