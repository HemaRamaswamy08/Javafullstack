package com.dyashin.springcode.annotation;

import org.springframework.stereotype.Component;

@Component
public class Bus implements Vehicle {

	public Bus() {

	}

	@Override
	public String milage() {
		return "80KMPh";
	}

}
