package com.neueda.tinyurl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

import com.neueda.tinyurl.repo.StatisticsRepository;
import com.neueda.tinyurl.utils.Constants;

@Aspect
@Component
public class RedirectionStatsCollector {
	
	private final StatisticsRepository repo;

	@Autowired
	public RedirectionStatsCollector(final StatisticsRepository repo) {
		this.repo = repo;
	}
	
	@AfterReturning(
			value = "execution(* com.neueda.tinyurl.service.RedirectionService.*(..)) and args(tinyUrl)", 
			returning = "redirectView")
	public void afterCreateTinyurl(final JoinPoint joinPoint, final String tinyUrl, final RedirectView redirectView) {
		repo.tinyUrlRedirectionStatistics(Constants.TINY_URL+tinyUrl); 
	}

}
