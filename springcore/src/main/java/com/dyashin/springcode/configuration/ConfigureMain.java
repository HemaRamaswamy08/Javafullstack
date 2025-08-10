package com.dyashin.springcode.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigureMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		StudentInfo studentInfo = context.getBean("studentInfo",StudentInfo.class);//-->studentInfo
		studentInfo.addres().stuff();;
		context.close();
		
		
	}

}
