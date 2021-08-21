package com.neueda.tinyurl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neueda.tinyurl.model.DomainUrl;
import com.neueda.tinyurl.repo.StatisticsRepository;

@Aspect
@Component
public class UserStatsCollector {
	
	private final StatisticsRepository repo;

	@Autowired
	public UserStatsCollector(final StatisticsRepository repo) {
		this.repo = repo;
	}
	
	@AfterReturning(
			value = "execution(* com.neueda.tinyurl.service.UrlService.*(..)) and args(url)", 
			returning = "tinyUrl")
	public void afterCreateTinyurl(final JoinPoint joinPoint, final DomainUrl url, final String tinyUrl) {
		repo.userRequestStatistics(url.getUser()); 
	}

}
