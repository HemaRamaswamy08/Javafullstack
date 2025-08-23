package com.dyashin.springpractice.confuguratation.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public User user() {
		return new User();
	}

	@Bean
	public UserRepository userRepo() {
		return new UserRepository(user());
	}

}
