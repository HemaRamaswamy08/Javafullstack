package com.dyashin.springpractice.confuguratation.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJava {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserRepository repo = context.getBean("userRepo",UserRepository.class);
		repo.register("resh");
	}
}
