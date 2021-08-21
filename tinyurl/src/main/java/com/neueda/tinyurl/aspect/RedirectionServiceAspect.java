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
public class RedirectionServiceAspect {
	
	private StatisticsRepository repo;

	@Autowired
	public RedirectionServiceAspect(StatisticsRepository repo) {
		this.repo = repo;
	}
	
	@AfterReturning(
			value = "execution(* com.neueda.tinyurl.service.RedirectionService.*(..)) and args(tinyUrl)", 
			returning = "redirectView")
	public void afterCreateTinyurl(JoinPoint joinPoint, String tinyUrl, RedirectView redirectView) {
		repo.tinyUrlRedirectionStatistics(Constants.TINY_URL+tinyUrl); 
	}

}
