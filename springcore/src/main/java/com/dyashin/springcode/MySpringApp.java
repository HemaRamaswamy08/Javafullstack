package com.dyashin.springcode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		Vehicle car =  context.getBean("mycar",Car.class);
		System.out.println(car.milage());
		System.out.println(car.getDiscount());
		
		Bus bus = (Bus) context.getBean("mybus",Bus.class);
		System.out.println("Bus "+bus.milage());
		System.out.println(bus.getDiscount());
		
		System.out.println();
		
		
		
		context.close();
	}

}
