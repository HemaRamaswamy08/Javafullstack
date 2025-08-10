package com.dyashin.springcode.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Student val = context.getBean("studentsetainjection",Student.class);
		val.getVariables();
	}

}
