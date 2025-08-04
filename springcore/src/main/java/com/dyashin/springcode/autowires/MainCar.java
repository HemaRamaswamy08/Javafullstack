package com.dyashin.springcode.autowires;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCar {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Car car = context.getBean("carExmp",Car.class);
		car.carMethod();
	}

}
