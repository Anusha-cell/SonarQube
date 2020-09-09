package com.galaxe.sonarQube.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Configurations {

//	
//	@Bean(name = "serviceNowRestTemplate")
//	public RestTemplate serviceNow() {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "Admin123"));
//		return restTemplate;
//	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	

	

}
