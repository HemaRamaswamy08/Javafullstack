package com.dyashin.springpractice.confuguratation.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		UserService service = context.getBean(UserService.class);

		service.registerUser("hema");
	}

}
