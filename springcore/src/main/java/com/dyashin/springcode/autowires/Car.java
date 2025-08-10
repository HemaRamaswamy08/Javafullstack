package com.dyashin.springcode.autowires;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carExmp")// -->This annotation registers Car as a Spring bean with the ID "carExmp" in xml so don't neeed to mention it explictly
public class Car {
	@Autowired //-->for Car we are injecting CarEngine
	// @Qualifier("name") --> resolving ambiguity when Spring needs to autowire a dependency, and there are multiple beans of the same type
	/*	Scenario : Interface A with 2 or more implementation , then we need to specify which 
	 class we want to inject at that time we use use this qualifier */
	CarEngine engin;

	public CarEngine getEngin() {
		return engin;
	}

	public void setEngin(CarEngine engin) {
		this.engin = engin;
	}

	public void carMethod() {
		System.out.println("Method inside a car");
		engin.carEngineMethod();
	}
}
