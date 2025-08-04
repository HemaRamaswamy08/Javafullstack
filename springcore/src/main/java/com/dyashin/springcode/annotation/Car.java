package com.dyashin.springcode.annotation;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	public Car() {

	}

	@Override
	public String milage() {
		return "100 KMPh";
	}

}
