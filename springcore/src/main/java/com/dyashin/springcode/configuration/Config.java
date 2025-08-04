package com.dyashin.springcode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
Act as an XMl file and generate a bean 
telling Spring that this class contains bean definitions (methods annotated with @Bean).
 Inside a @Configuration class, you define your beans by creating methods that return an instance of the class you want to register as a bean. These methods are annotated with @Bean.
*/
@Configuration
@ComponentScan("com.dyashin.springcode")
public class Config {

	@Bean // --> By default method name is considered as ID
	public StudentInfo studentInfo() {
		return new StudentInfo();

	}

}
