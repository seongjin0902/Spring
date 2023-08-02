package com.test.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.app.domain.dto.Person;

@Configuration
public class AppConfiguration {
	
	@Bean("myPerson")
	public Person PersonFunc() {
		return new Person().builder()
				.name("오구")
				.age(26)
				.addr("대구")
				.build();
	}	
}
