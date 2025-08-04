package com.dyashin.springcode.autowires;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Bike b = context.getBean("bikeengine",Bike.class);
		b.start();
	}

}
