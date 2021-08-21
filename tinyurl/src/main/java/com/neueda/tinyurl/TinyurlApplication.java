package com.neueda.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)  
public class TinyurlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyurlApplication.class, args);
	}

}
