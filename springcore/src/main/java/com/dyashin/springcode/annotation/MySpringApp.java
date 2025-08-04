package com.dyashin.springcode.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Vehicle car = context.getBean("car", Vehicle.class);
		System.out.println(car.milage());

		Vehicle bus = context.getBean("bus", Vehicle.class);
		System.out.println("Bus " + bus.milage());

		System.out.println();

		context.close();
	}

}
