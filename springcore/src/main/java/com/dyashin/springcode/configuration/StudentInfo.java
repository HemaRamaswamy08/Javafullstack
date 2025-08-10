package com.dyashin.springcode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dyashin.springcode")
public class StudentInfo {

	@Bean
	public Address addres() {
		return new Address(new StudentInfo());
	}

	public void name() {
		System.out.println("Student method");
	}
}
