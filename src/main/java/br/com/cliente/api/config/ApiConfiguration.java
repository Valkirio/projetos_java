package br.com.cliente.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "br.com.cliente.api")
public class ApiConfiguration {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}